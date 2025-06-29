package moe.crx.roadblock.push

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.ServerError
import moe.crx.roadblock.rpc.base.Packet
import moe.crx.roadblock.rpc.base.PacketDirection

open class PushMessagePacket() : Packet(PacketDirection.PUSH) {

    var type: Short = 0
    var error: ServerError? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        type = if (sink newer "24.0.0") {
            sink.readShort()
        } else {
            sink.readByte().toShort()
        }
        error = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        if (sink newer "24.0.0") {
            sink.writeShort(type)
        } else {
            sink.writeByte(type.toByte())
        }
        sink.writeOptional(error)
    }
}