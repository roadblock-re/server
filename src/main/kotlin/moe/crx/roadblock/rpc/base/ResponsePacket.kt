package moe.crx.roadblock.rpc.base

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ActionResponseHeader
import moe.crx.roadblock.objects.game.ServerError

open class ResponsePacket : RObject {

    var header: ActionResponseHeader = ActionResponseHeader()
    var type: Short = 0
    var error: ServerError? = null

    override fun read(sink: InputSink) {
        if (sink newer "24.0.0") {
            check(sink.readByte() == 7.toByte())
        } else {
            check(sink.readByte() == 5.toByte())
        }
        header = sink.readObject()
        type = if (sink newer "24.0.0") {
            sink.readShort()
        } else {
            sink.readByte().toShort()
        }
        error = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        if (sink newer "24.0.0") {
            sink.writeByte(7)
        } else {
            sink.writeByte(5)
        }
        sink.writeObject(header)
        if (sink newer "24.0.0") {
            sink.writeShort(type)
        } else {
            sink.writeByte(type.toByte())
        }
        sink.writeOptional(error)
    }
}