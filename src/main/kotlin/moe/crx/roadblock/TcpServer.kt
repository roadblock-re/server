package moe.crx.roadblock

import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.utils.*
import net.jpountz.lz4.LZ4Compressor
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
val highCompressor: LZ4Compressor = LZ4Factory.fastestInstance().highCompressor()
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

                runCatching {
                    val nonce = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                    output.write("{\"action\":\"create connection\",\"success\":\"True\",\"nonce\":\"$nonce\"}\n".toByteArray())
                    output.flush()

                    // Contains action, room_id, access_token
                    val roomId = BufferedReader(InputStreamReader(input)).readLine()
                        .let { Json.parseToJsonElement(it) }.jsonObject["room_id"]?.jsonPrimitive?.contentOrNull
                    checkNotNull(roomId)

                    val slot = "aaaa"
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

                    fun sendPacket(bytes: ByteArray, type: Int) {
                        val trimmedLength = bytes.size and 0xFFFFFFF
                        check(trimmedLength == bytes.size)

                        val shiftedType = type shl 0x1C
                        val header = trimmedLength or shiftedType

                        encrypt.processBytes(bytes.copyOf(), 0, bytes.size, bytes, 0)

                        output.write(header.toBigEndianBytes())
                        output.write(bytes)
                        output.flush()
                    }

                    val gameConnection = GameConnection(ignoreConnect = true) { payloadBytes, preferDeflated ->
                        var (bytes, type) = if (preferDeflated) {
                            var compressed = highCompressor.compress(payloadBytes)
                            val hash = xxHash32.hash(compressed, 0, compressed.size, payloadBytes.size)

                            val finalBytes =
                                hash.toBigEndianBytes() + payloadBytes.size.toLittleEndianBytes() + compressed
                            finalBytes to 1
                        } else {
                            payloadBytes to 0
                        }

                        sendPacket(bytes, type)
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

                        // Asio keepalive request
                        if (type == 15) {
                            // Bytes are seem to be a sequence number but string.
                            sendPacket(bytes, 14)
                            continue
                        }

                        // Asio keepalive response
                        if (type == 14) {
                            // Is used when server requests keepalive.
                            println("KeepaliveRsp received: ${bytes.toHexString()}")
                            continue
                        }

                        if (type == 1) {
                            val hash = bytes.take(4).toByteArray().toBigEndianInt()
                            val decompressedLength = bytes.drop(4).take(4).toByteArray().toBigEndianInt()
                            val compressedBytes = bytes.drop(8).toByteArray()

                            val calculatedHash =
                                xxHash32.hash(compressedBytes, 0, compressedBytes.size, decompressedLength)
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
    }

    if (wait) {
        runBlocking {
            job.join()
        }
    }

    return job
}
