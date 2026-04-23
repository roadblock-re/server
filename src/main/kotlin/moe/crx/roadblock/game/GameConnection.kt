package moe.crx.roadblock.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.DateTimeUnit.Companion.HOUR
import kotlinx.datetime.Instant
import kotlinx.datetime.plus
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import moe.crx.roadblock.core.Configuration
import moe.crx.roadblock.core.utils.midnight
import moe.crx.roadblock.core.utils.toHexString
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.game.serialization.RoadblockFormat
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.enumListOf
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.playerstats.GameplayTutorialType
import moe.crx.roadblock.objects.playerstats.MenuTutorialType
import moe.crx.roadblock.rpc.SendTrackingEventsRequest
import moe.crx.roadblock.rpc.base.*
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

// TODO plugin system
// TODO UpdatesConsumer for State and it's members (create updates to send, and then apply them to state) (use Kotlin getters/setters?)
// TODO Original serial names from binaries

class GameConnection(
    val workingDirectory: String,
    var config: Configuration,
    val ignoreConnect: Boolean = false,
    val sendBlock: suspend (ByteArray, Boolean) -> Unit
) {
    companion object {
        val LOG: Logger = LoggerFactory.getLogger("roadblock.game")
        val json = Json
    }

    enum class ConnectionState {
        NOT_INITIALIZED, NOT_AUTHORIZED, AUTHORIZED
    }

    var ver = SerializationVersion()
    var format = RoadblockFormat(ver)
    var layer = GameLayer(workingDirectory, ver)

    var connectionState = ConnectionState.NOT_INITIALIZED
    var onlineInformationSent = false

    var packetLock: ReentrantLock = ReentrantLock()

    // TODO Fix this trash
    var lastRequestSequence = -2
    var requestSequence = 0
    var requestType: UShort = 0u

    val stateManager = StateManager(workingDirectory)
    var gameState = stateManager.default(ver)

    suspend fun send(bytes: ByteArray, preferDeflated: Boolean = false) {
        // TODO print received packets ANSI
        //LOG.info("[O] {}", bytes.toHexString())
        sendBlock(bytes, preferDeflated)
    }

    suspend inline fun <reified T> sendResponse(response: T, customTimestamp: Instant? = null) {
        check(requestType.toInt() != 0)

        (response as? ResponsePacket)?.apply {
            header.nextActionId = (requestSequence + 2).toUInt()
            header.lastCommittedActionId = lastRequestSequence.toUInt()
            header.serverTime = customTimestamp ?: now()
            type = requestType
        }

        if (config.stripUpdatesQueues) {
            (response as? UpdatesQueueWithRootReactionsResponse)?.apply {
                updates = StatusUpdatesQueueWithRootReactions()
            }
        }

        lastRequestSequence = requestSequence
        requestType = 0u

        sendObject(response)
    }

    suspend inline fun <reified T> sendObject(value: T) {
        val bytes = format.encodeToByteArray(value)
        send(bytes, bytes.size > 1024)
    }

    suspend fun receive(bytes: ByteArray) {
        // TODO Rewrite handling of packet header types

        if (connectionState == ConnectionState.NOT_INITIALIZED && ignoreConnect) {
            connectionState = ConnectionState.NOT_AUTHORIZED
        }

        // TODO handle reconnect packet properly
        if (bytes.first().toInt() == 2 && connectionState == ConnectionState.NOT_AUTHORIZED) {
            connectionState = ConnectionState.AUTHORIZED

            gameState = stateManager.read(ver)

            sendObject(
                ReconnectionResponse(
                    magic = 2u,
                    error = null,
                    lastActionId = lastRequestSequence.toUInt(),
                    lastCommittedActionId = lastRequestSequence.toUInt(),
                )
            )
            return
        }

        if (bytes.first().toInt() == 4) {
            // TODO
            LOG.info("TODO AlertControlRequest")
            bytes[0] = 9
            //send(bytes)
            return
        }

        if (bytes.first().toInt() == 1) {
            // TODO
            LOG.info("TODO ResetStateRequest")
            send(bytes)
            return
        }

        // TODO Move to WebSocket handler
        if (connectionState == ConnectionState.NOT_INITIALIZED) {
            val handshake = json.decodeFromString<ConnectGameRequest>(bytes.toString(Charsets.UTF_8))
            LOG.info("Game connected with fedId {} and roomId {}", handshake.fedId, handshake.roomId)
            connectionState = ConnectionState.NOT_AUTHORIZED
            return
        }

        // TODO preserve game state, so it won't require auth on reconnect
        if (bytes.first().toInt() == 0) {
            val loginHeader = format.decodeFromByteArray<GameLoginRequestHeader>(bytes)

            ver = SerializationVersion(loginHeader.gameVersion)
            format = RoadblockFormat(ver)
            layer = GameLayer(workingDirectory, ver)

            format.decodeFromByteArray<GameLoginRequest>(bytes)

            LOG.info(
                "[I] Game authorized, negotiated version {}.{}.{}, {} packet types",
                ver.major,
                ver.minor,
                ver.build,
                layer.handlers.size
            )
            connectionState = ConnectionState.AUTHORIZED

            gameState = stateManager.read(ver)

            val loginResponse = GameLoginResponse(
                lastServerActionId = 0u,
                actionResponseParams = ActionResponseHeader(),
                configData = ConfigData(
                    compression = CompressionType.LZ4,
                    data = Blob(layer.getConfig().readBytes()),
                ),
                serverDBs = ServerDBDataSerialization(
                    gameDb = ConfigData(
                        compression = CompressionType.LZ4,
                        data = Blob(layer.getGameDb().readBytes()),
                    )
                ),
                serializationVersion = GameLayer.reportVersion(ver),
                state = gameState,
            )

            loginResponse.state.apply {
                clubSystem.clubData = null
                miscellaneous.resetAdsReplacementTimepoint = now().midnight().plus(24, HOUR)
                blackMarket.nextAutoRefreshTime = now().midnight().plus(24, HOUR)
                blackMarket.nextDailyResetTime = now().midnight().plus(24, HOUR)
                dailyTasks.state.resetTime = now().midnight().plus(24, HOUR)
                vipSystem.vipBlackMarketState.nextAutoRefreshTime = now().midnight().plus(24, HOUR)
                vipSystem.vipBlackMarketState.nextDailyResetTime = now().midnight().plus(24, HOUR)
                gauntletSystem.market.nextAutoRefreshTime = now().midnight().plus(24, HOUR)
                clubWars.market.nextAutoRefreshTime = now().midnight().plus(24, HOUR)
            }

            loginResponse.state = loginResponse.state.copy().apply {
                playerStats = gameState.playerStats.copy().apply {
                    menuTutorials =
                        enumListOf(MenuTutorialType.lastEntryFor(ver)) {
                            gameState.playerStats.menuTutorials[it]
                        }
                    gameplayTutorials =
                        enumListOf(GameplayTutorialType.lastEntryFor(ver)) {
                            gameState.playerStats.gameplayTutorials[it]
                        }
                }
            }

            return sendObject(loginResponse)
        }

        if (!onlineInformationSent && connectionState == ConnectionState.AUTHORIZED) {
            onlineInformationSent = true

            // TODO Send push messages
            // TODO Send event calendar (otherwise game will wait for it and freeze)
        }

        packetLock.lock()

        val header = format.decodeFromByteArray<RequestPacket>(bytes)

        requestSequence = header.header.actionId.toInt()
        requestType = header.type

        if (requestSequence != lastRequestSequence + 2) {
            LOG.warn(
                "Client sequence number is out of sync (current is {}, sent is {})",
                lastRequestSequence,
                requestSequence
            )
        }

        val handlerEntry = layer.handlers.getOrNull(header.type.toInt())
        val handler = handlerEntry?.handle

        if (handlerEntry == null || handler == null) {
            LOG.warn(
                ansi().fgBrightYellow().a("[I] Unknown packet {} (ID {}) {}").reset().toString(),
                handlerEntry?.requestName ?: "<unknown name>",
                header.type,
                bytes.toHexString()
            )

            //sendConcurrentAccess() // TODO config option

            packetLock.unlock()

            return
        }

        val request = runCatching {
            @Suppress("UNCHECKED_CAST")
            @OptIn(InternalSerializationApi::class)
            val serializer = handlerEntry.requestClass.serializer() as KSerializer<RequestPacket>
            val deserialized = format.decodeFromByteArray(serializer, bytes)

            if (config.checkReceivedRequestSize && handlerEntry.requestClass != SendTrackingEventsRequest::class) {
                val serializedBytes = format.encodeToByteArray(serializer, deserialized)
                val byteDelta = bytes.size - serializedBytes.size
                check(byteDelta == 0) { "Packet isn't read until the end, $byteDelta bytes still available" }
            }

            deserialized
        }.onFailure { throwable ->
            LOG.error("[I] Error reading packet {} (ID {})", handlerEntry.requestName, header.type)
            throwable.printStackTrace()

            reportHandlingError(handlerEntry.requestName, header.type, bytes, throwable)

            //sendConcurrentAccess() // TODO config option

            packetLock.unlock()

            return
        }.getOrThrow()

        val packetDesc = if (config.printFullPackets) {
            request.toString()
        } else {
            request.javaClass.simpleName
        }

        runCatching {
            handler(this, request)
        }.onSuccess {
            LOG.info("[I] Handled packet {} (ID {})", packetDesc, request.type)
        }.onFailure { throwable ->
            LOG.error("[I] Error handling packet {} (ID {})", packetDesc, request.type)
            throwable.printStackTrace()

            reportHandlingError(request.toString(), request.type, bytes, throwable)

            //sendConcurrentAccess() // TODO config option
        }

        saveState()

        packetLock.unlock()
    }

    fun reportHandlingError(name: String, type: UShort, bytes: ByteArray, throwable: Throwable) {
        File(File(workingDirectory, "reports"), "${System.currentTimeMillis()}.report").run {
            parentFile.mkdirs()

            FileWriter(this).use { writer ->
                writer.write("Error handling packet $name (ID $type):\n\n")
                throwable.printStackTrace(PrintWriter(writer))
                writer.write("\nRequest packet bytes:\n")
                writer.write(bytes.toHexString())
                writer.write("\nProtocol version: ${ver.major}.${ver.minor}.${ver.build}\n")
            }
        }
    }

    suspend fun sendConcurrentAccess() {
        send(byteArrayOf(0x03))
    }

    fun close() {
        saveState()
        LOG.info("Game connection closed")
    }

    fun saveState() {
        stateManager.write(gameState, ver)
    }
}