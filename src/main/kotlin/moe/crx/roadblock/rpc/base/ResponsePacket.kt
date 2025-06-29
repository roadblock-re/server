package moe.crx.roadblock.rpc.base

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.ServerError

open class ResponsePacket() : Packet(PacketDirection.RESPONSE) {

    var responseSequence: Int = 0
    var previousRequestSequence: Int = 0
    var timestamp: Instant = now()
    var type: Short = 0
    var error: ServerError? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        responseSequence = sink.readInt()
        previousRequestSequence = sink.readInt()
        timestamp = sink.readInstant()
        type = if (sink newer "24.0.0") {
            sink.readShort()
        } else {
            sink.readByte().toShort()
        }
        error = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(responseSequence)
        sink.writeInt(previousRequestSequence)
        sink.writeInstant(timestamp)
        if (sink newer "24.0.0") {
            sink.writeShort(type)
        } else {
            sink.writeByte(type.toByte())
        }
        sink.writeOptional(error)
    }
}