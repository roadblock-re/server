package moe.crx.roadblock.game

import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.rpc.base.RequestPacket
import kotlin.reflect.KClass

data class PacketHandler(
    val requestClass: KClass<out RequestPacket>,
    val handle: suspend (GameConnection, RequestPacket) -> Unit,
)

abstract class PacketLayer(val ver: SerializationVersion) {

    // There are also LoginRequest/LoginRequest at nil index, but it seems to be unused
    var currentId = 1
    var handlers: MutableMap<Byte, PacketHandler?> = mutableMapOf()

    fun registerStub() {
        register<RequestPacket>(null)
    }

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : RequestPacket> register(
        noinline handle: (suspend (GameConnection, T) -> Unit)?
    ) {
        check(!handlers.containsKey(currentId.toByte())) {
            "Handler with ID $currentId was already registered."
        }

        handlers.put(
            currentId.toByte(),
            handle?.let {
                PacketHandler(
                    T::class,
                    it as suspend (GameConnection, RequestPacket) -> Unit,
                )
            })
        ++currentId
    }

    fun mapPacket(type: Byte) = handlers[type]
}