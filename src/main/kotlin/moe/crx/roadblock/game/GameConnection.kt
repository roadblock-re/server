package moe.crx.roadblock.game

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.objects.game.*
import moe.crx.roadblock.push.PushMessagePacket
import moe.crx.roadblock.rpc.auth.ConnectGameRequest
import moe.crx.roadblock.rpc.auth.LoginRequest
import moe.crx.roadblock.rpc.auth.LoginResponse
import moe.crx.roadblock.rpc.auth.LoginResponse.Companion.GAME_SIGNATURE
import moe.crx.roadblock.rpc.base.ReconnectionResponse
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket
import moe.crx.roadblock.utils.bytes
import moe.crx.roadblock.utils.readFully
import moe.crx.roadblock.utils.sink
import moe.crx.roadblock.utils.toHexString
import org.fusesource.jansi.Ansi.ansi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.util.concurrent.locks.ReentrantLock

// TODO (De)Serialization:
// - Game database
// - Client tracking updates
// - Multiplayer packets

// TODO rewrite packets to variants
// TODO plugin system
// TODO UpdatesConsumer for State and it's members (create updates to send, and then apply them to state)
// TODO Rework GameState members types
// TODO look through all enums and set the right size where necessary

class GameConnection(val ignoreConnect: Boolean = false, val sendBlock: suspend (ByteArray, Boolean) -> Unit) {
    companion object {
        val LOG: Logger = LoggerFactory.getLogger("roadblock.game")
    }

    enum class ConnectionState {
        NOT_INITIALIZED, NOT_AUTHORIZED, AUTHORIZED
    }

    var connectionState = ConnectionState.NOT_INITIALIZED
    var onlineInformationSent = false
    val cliJob: Job
    var gameState = StateManager.default()
    val layer = GameLayer24014
    val ver: SerializationVersion
        get() = layer.ver

    var packetLock: ReentrantLock = ReentrantLock()
    var lastRequestSequence = 0
    var requestSequence = 0
    var requestType: Short = 0

    init {
        LOG.info("Game connection created")
        cliJob = CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                val line = readln()

                if (line.isBlank()) {
                    continue
                }

                val bytes = runCatching {
                    line.split(",").first().run {
                        if (startsWith("\"") && endsWith("\"")) {
                            substring(1, length - 1)
                        } else {
                            this
                        }
                    }.let {
                        File(it).readBytes()
                    }
                }.getOrNull() ?: runCatching {
                    line.replace(" ", "").windowed(2, 2) {
                        it.substring(0).toByte(16)
                    }.toByteArray()
                }.getOrNull()

                if (bytes == null) {
                    continue
                }

                runCatching { bytes.sink(layer.ver).readObject<ResponsePacket>().type }.getOrNull()?.let { id ->
                    LOG.info("Sending response packet with ID {}", id)
                }
                runCatching { bytes.sink(layer.ver).readObject<PushMessagePacket>().type }.getOrNull()?.let { id ->
                    LOG.info("Sending push message packet with ID {}", id)
                }
                send(bytes)
            }
        }
    }

    suspend fun send(bytes: ByteArray, preferDeflated: Boolean = false) {
        // TODO print received packets ANSI
        //LOG.info("[O] {}", bytes.toHexString())
        sendBlock(bytes, preferDeflated)
    }

    suspend fun send(response: ResponsePacket, customTimestamp: Instant? = null) {
        check(requestType.toInt() != 0)

        response.apply {
            responseSequence = requestSequence + 1
            previousRequestSequence = lastRequestSequence
            timestamp = customTimestamp ?: now()
            type = requestType
        }

        lastRequestSequence = requestSequence
        requestType = 0

        send(response.bytes(layer.ver))
    }

    suspend fun receive(bytes: ByteArray) {
        // TODO Rewrite handling of packet header types

        if (connectionState == ConnectionState.NOT_INITIALIZED && ignoreConnect) {
            connectionState = ConnectionState.NOT_AUTHORIZED
        }

        // TODO handle reconnect packet properly
        if (bytes.first().toInt() == 2 && connectionState == ConnectionState.NOT_AUTHORIZED) {
            connectionState = ConnectionState.AUTHORIZED

            runCatching {
                gameState = StateManager.read(layer.ver)
            }

            send(ReconnectionResponse().apply {
                lastActionId = lastRequestSequence
                lastCommitedActionId = lastRequestSequence
            }.bytes(layer.ver))
            return
        }

        if (bytes.first().toInt() == 4) {
            // TODO
            LOG.info("AlertControlRequest")
            send(bytes)
            return
        }

        if (bytes.first().toInt() == 1) {
            // TODO
            LOG.info("ResetStateRequest")
            send(bytes)
            return
        }

        // TODO Move to WebSocket handler
        if (connectionState == ConnectionState.NOT_INITIALIZED) {
            val handshake = bytes.sink(layer.ver).readFully<ConnectGameRequest>()
            LOG.info("Game connected with fedId {} and roomId {}", handshake.fedId, handshake.roomId)
            connectionState = ConnectionState.NOT_AUTHORIZED
            return
        }

        // TODO preserve game state, so it won't require auth on reconnect
        if (bytes.first().toInt() == 0) {
            bytes.sink(layer.ver).readFully<LoginRequest>()
            LOG.info("[I] Game authorized")
            connectionState = ConnectionState.AUTHORIZED

            runCatching {
                gameState = StateManager.read(layer.ver)
            }

            LoginResponse().apply {
                userSessionId = "506746a9-0f5e-4827-9dfc-eb9ccbad8b81"
                revision = "b1610"
                actionResponseParams = ActionResponseHeader() // TODO
                lastServerActionId = 0
                serverSyslogId = "a9b-aaaaaaaa-bbbbbbbb"
                buildId = "b1610"
                didMaintenanceFreeRefill = false
                remindNewGarageLevel = false
                isClientReloadNeeded = false
                isVipPlayer = false
                signatureValue = GAME_SIGNATURE
                serializationVersion = layer.ver
                configData = ConfigData().apply {
                    compressionType = CompressionType.LZ4
                    data = layer.getConfig().readBytes()
                }
                serverDBs = ServerDBSerialization().apply {
                    gameDb = ConfigData().apply {
                        compressionType = CompressionType.LZ4
                        data = layer.getGameDb().readBytes()
                    }
                }
                state = gameState
            }.let {
                send(it.bytes(layer.ver), true)
            }

            return
        }

        if (!onlineInformationSent && connectionState == ConnectionState.AUTHORIZED) {
            onlineInformationSent = true

            // TODO Send push messages
        }

        packetLock.lock()

        val header = bytes.sink(layer.ver).readObject<RequestPacket>()

        requestSequence = header.sequence
        requestType = header.type

        if (requestSequence > lastRequestSequence + 1) {
            LOG.warn(
                "Client sequence number is out of sync (current is {}, sent is {})",
                lastRequestSequence,
                requestSequence
            )
        }

        val handlerEntry = layer.mapPacket(header.type)
        val handler = handlerEntry?.handle

        if (handlerEntry == null || handler == null) {
            LOG.warn(
                ansi().fgBrightYellow().a("[I] Unknown packet {} (ID {}) {}").reset().toString(),
                handlerEntry?.requestName ?: "<unknown name>",
                header.type,
                bytes.toHexString()
            )

            sendConcurrentAccess()

            packetLock.unlock()

            return
        }

        val request = runCatching {
            bytes.sink(layer.ver).readFully(handlerEntry.requestClass)
        }.onFailure { throwable ->
            LOG.error("[I] Error reading packet {} (ID {})", handlerEntry.requestName, header.type)
            throwable.printStackTrace()

            reportHandlingError(header, bytes, throwable)

            sendConcurrentAccess()

            packetLock.unlock()

            return
        }.getOrThrow()

        runCatching {
            handler(this, request)
        }.onSuccess {
            LOG.info("[I] Handled packet {} (ID {})", request.javaClass.simpleName, request.type)
        }.onFailure { throwable ->
            LOG.error("[I] Error handling packet {} (ID {})", request.javaClass.simpleName, request.type)
            throwable.printStackTrace()

            reportHandlingError(request, bytes, throwable)

            sendConcurrentAccess()

            packetLock.unlock()

            return
        }

        packetLock.unlock()
    }

    fun reportHandlingError(request: RequestPacket, bytes: ByteArray, throwable: Throwable) {
        File("reports", "${System.currentTimeMillis()}.report").run {
            parentFile.mkdirs()

            FileWriter(this).use { writer ->
                writer.write("Error handling packet ${request.javaClass.simpleName} (ID ${request.type}):\n\n")
                throwable.printStackTrace(PrintWriter(writer))
                writer.write("\nRequest packet bytes:\n")
                writer.write(bytes.toHexString())
            }
        }
    }

    suspend fun sendConcurrentAccess() {
        send(byteArrayOf(0x03))
    }

    fun close() {
        LOG.info("Game connection closed")
        cliJob.cancel()
    }

    fun saveState() {
        StateManager.write(gameState, layer.ver)
    }
}