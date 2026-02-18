package moe.crx.roadblock.rpc.base

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ActionRequestHeader

open class RequestPacket : RObject {

    var header: ActionRequestHeader = ActionRequestHeader()
    var type: Short = 0

    override fun read(sink: InputSink) {
        check(sink.readByte() == 3.toByte())
        header = sink.readObject()
        type = if (sink newer "24.0.0") {
            sink.readShort()
        } else {
            sink.readByte().toShort()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(3)
        sink.writeObject(header)
        if (sink newer "24.0.0") {
            sink.writeShort(type)
        } else {
            sink.writeByte(type.toByte())
        }
    }
}