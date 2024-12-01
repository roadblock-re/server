package moe.crx.roadblock

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket
import moe.crx.roadblock.rpc.base.SpecialPacketHeader
import moe.crx.roadblock.utils.sink
import java.io.File
import kotlin.math.min

fun main() {
    val serializationVersion = SerializationVersion().apply {
        major = 3
        minor = 9
        build = 2
    }
    val requests = mutableMapOf<Byte, MutableList<File>>()
    val responses = mutableMapOf<Byte, MutableList<File>>()
    val special = mutableMapOf<Byte, MutableList<File>>()

    print("Enter packets path: ")
    File(readln()).walkTopDown().forEach {
        if (!it.isFile) {
            return@forEach
        }

        val bytes = it.inputStream().use { stream ->
            stream.readNBytes(min(it.length(), 100).toInt())
        }

        runCatching { bytes.sink(serializationVersion).readObject<RequestPacket>().type }.getOrNull()?.let { id ->
            requests.getOrPut(id) { mutableListOf() }.add(it)
        }
        runCatching { bytes.sink(serializationVersion).readObject<ResponsePacket>().type }.getOrNull()?.let { id ->
            responses.getOrPut(id) { mutableListOf() }.add(it)
        }
        runCatching { bytes.sink(serializationVersion).readObject<SpecialPacketHeader>().type }.getOrNull()?.let { id ->
            special.getOrPut(id) { mutableListOf() }.add(it)
        }
    }

    listOf(requests, responses, special).forEach { dict ->
        dict.forEach { packetId, files ->
            println("%02x".format(packetId) + ": " + files.joinToString())
        }
        println()
        println()
        println()
    }
}