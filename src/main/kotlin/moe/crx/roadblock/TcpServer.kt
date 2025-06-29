package moe.crx.roadblock

import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.utils.evpBytesToKey
import moe.crx.roadblock.utils.toBigEndianBytes
import moe.crx.roadblock.utils.toBigEndianInt
import moe.crx.roadblock.utils.toHexString
import moe.crx.roadblock.utils.toLittleEndianInt
import net.jpountz.lz4.LZ4Factory
import net.jpountz.lz4.LZ4SafeDecompressor
import net.jpountz.xxhash.XXHash32
import net.jpountz.xxhash.XXHashFactory
import org.bouncycastle.crypto.engines.ChaCha7539Engine
import org.bouncycastle.crypto.params.KeyParameter
import org.bouncycastle.crypto.params.ParametersWithIV
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket

val safeDecompressor: LZ4SafeDecompressor = LZ4Factory.fastestInstance().safeDecompressor()
val xxHash32: XXHash32 = XXHashFactory.fastestInstance().hash32()

val clientSalt = byteArrayOf(0x63, 0x6C, 0x69, 0x65, 0x6E, 0x74, 0x00, 0x00) // "client\0\0"
val serverSalt = byteArrayOf(0x73, 0x65, 0x72, 0x76, 0x65, 0x72, 0x00, 0x00) // "server\0\0"

val scope = CoroutineScope(Dispatchers.IO)

fun tcpServer(wait: Boolean): Job {
    val socket = ServerSocket(4447)

    val job = scope.launch {
        while (true) {
            val client = socket.accept()

            scope.launch {
                val output = client.outputStream
                val input = client.inputStream

                val slot = "aaaa"

                output.write("{\"action\":\"create connection\",\"success\":\"True\",\"nonce\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}\n".toByteArray())
                output.flush()

                // Contains action, room_id, access_token
                val roomId = BufferedReader(InputStreamReader(input)).readLine()
                    .let { Json.parseToJsonElement(it) }.jsonObject["room_id"]?.jsonPrimitive?.contentOrNull
                checkNotNull(roomId)

                output.write("{\"slot\":\"$slot\",\"success\":true,\"action\":\"connect game\"}\n".toByteArray())
                output.flush()

                val decrypt = evpBytesToKey((roomId + slot).toByteArray(), clientSalt).let { (key, iv) ->
                    ChaCha7539Engine().apply {
                        init(false, ParametersWithIV(KeyParameter(key), iv.takeLast(12).toByteArray()))
                        skip((iv.take(4).toByteArray().toLittleEndianInt().toLong() and 0xFFFFFFFFL) * 64.toLong())
                    }
                }
                val encrypt = evpBytesToKey((roomId + slot).toByteArray(), serverSalt).let { (key, iv) ->
                    ChaCha7539Engine().apply {
                        init(true, ParametersWithIV(KeyParameter(key), iv.takeLast(12).toByteArray()))
                        skip((iv.take(4).toByteArray().toLittleEndianInt().toLong() and 0xFFFFFFFFL) * 64.toLong())
                    }
                }

                val gameConnection = GameConnection(ignoreConnect = true) { bytes, preferDeflated ->
                    // TODO LZ4 support
                    encrypt.processBytes(bytes.copyOf(), 0, bytes.size, bytes, 0)
                    output.write((bytes.size and 0xFFFFFFF).toBigEndianBytes())
                    output.write(bytes)
                    output.flush()
                }

                while (!client.isClosed) {
                    var headerBytes = ByteArray(0)

                    while (headerBytes.size < 4) {
                        headerBytes += input.readNBytes(4 - headerBytes.size)
                    }

                    val header = headerBytes.toBigEndianInt()
                    val length = header and 0xFFFFFFF
                    val type = header ushr 0x1C
                    var bytes = ByteArray(0)

                    while (bytes.size < length) {
                        bytes += input.readNBytes(length - bytes.size)
                    }

                    decrypt.processBytes(bytes.copyOf(), 0, bytes.size, bytes, 0)

                    // MessageTypes from server to client:
                    //    None,
                    //    Normal,
                    //    KeepaliveMsg,
                    //    KeepaliveRsp,

                    if (type == 15) {
                        // TODO
                        println("AsioKeepalive ${bytes.toHexString()}")
                        continue
                    }

                    if (type == 14) {
                        // TODO
                        println("KeepaliveRsp ${bytes.toHexString()}")
                        continue
                    }

                    if (type == 1) {
                        val hash = bytes.take(4).toByteArray().toBigEndianInt()
                        val decompressedLength = bytes.drop(4).take(4).toByteArray().toBigEndianInt()
                        val compressedBytes = bytes.drop(8).toByteArray()

                        val calculatedHash = xxHash32.hash(compressedBytes, 0, compressedBytes.size, decompressedLength)
                        check(hash == calculatedHash)

                        bytes = safeDecompressor.decompress(compressedBytes, decompressedLength)
                    }

                    runCatching {
                        gameConnection.receive(bytes)
                    }.onFailure {
                        it.printStackTrace()
                        client.close()
                    }
                }

                output.close()
                input.close()
            }
        }
    }

    if (wait) {
        runBlocking {
            job.join()
        }
    }

    return job
}