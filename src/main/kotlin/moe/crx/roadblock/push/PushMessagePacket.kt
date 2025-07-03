package moe.crx.roadblock.push

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ServerError

open class PushMessagePacket : RObject {

    var type: Short = 0
    var error: ServerError? = null

    override fun read(sink: InputSink) {
        if (sink newer "24.0.0") {
            check(sink.readByte() == 10.toByte())
        } else {
            check(sink.readByte() == 6.toByte())
        }
        type = if (sink newer "24.0.0") {
            sink.readShort()
        } else {
            sink.readByte().toShort()
        }
        error = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        if (sink newer "24.0.0") {
            sink.writeByte(10)
        } else {
            sink.writeByte(6)
        }
        if (sink newer "24.0.0") {
            sink.writeShort(type)
        } else {
            sink.writeByte(type.toByte())
        }
        sink.writeOptional(error)
    }
}