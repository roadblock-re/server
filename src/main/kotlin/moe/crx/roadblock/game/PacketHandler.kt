package moe.crx.roadblock.game

import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.rpc.base.RequestPacket
import java.io.File
import kotlin.reflect.KClass

data class PacketHandler(
    val requestName: String,
    val requestClass: KClass<out RequestPacket>,
    val handle: (suspend (GameConnection, RequestPacket) -> Unit)?,
)

abstract class GameLayer(val ver: SerializationVersion) {

    var currentId = 0
    var handlers: MutableMap<Byte, PacketHandler?> = mutableMapOf()

    fun registerStub(requestName: String? = null) {
        check(!handlers.containsKey(currentId.toByte())) {
            "Handler with ID $currentId was already registered."
        }

        handlers.put(
            currentId.toByte(),
            PacketHandler(
                requestName ?: "<unknown name>",
                RequestPacket::class,
                null,
            )
        )

        ++currentId
    }

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : RequestPacket> register(
        noinline handle: (suspend (GameConnection, T) -> Unit)
    ) {
        check(!handlers.containsKey(currentId.toByte())) {
            "Handler with ID $currentId was already registered."
        }

        handlers.put(
            currentId.toByte(),
            PacketHandler(
                T::class.java.simpleName,
                T::class,
                handle as suspend (GameConnection, RequestPacket) -> Unit,
            )
        )

        ++currentId
    }

    fun getConfig(): File {
        return File(File("game", "${ver.major}.${ver.minor}.${ver.build}"), "clientconfig.json")
    }

    fun getGameDb(): File {
        return File(File("game", "${ver.major}.${ver.minor}.${ver.build}"), "A9-business.gdb")
    }

    fun mapPacket(type: Byte) = handlers[type]
}