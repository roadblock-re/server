package moe.crx.roadblock.push.base

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.ServerError
import moe.crx.roadblock.rpc.base.Packet
import moe.crx.roadblock.rpc.base.PacketDirection

open class PushMessagePacket() : Packet(PacketDirection.SPECIAL) {

    var type: Byte = 0
    var error: ServerError? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        type = sink.readByte()
        error = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeByte(type)
        sink.writeOptional(error)
    }
}