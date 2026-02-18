package moe.crx.roadblock.objects.club

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubLogo : RObject {

    var shape: Short = 0
    var color: Byte = 0
    var flag: Short = 0
    var isFlagIcon: Boolean = false

    override fun read(sink: InputSink) {
        shape = sink.readShort()
        color = sink.readByte()
        flag = sink.readShort()
        isFlagIcon = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(shape)
        sink.writeByte(color)
        sink.writeShort(flag)
        sink.writeBoolean(isFlagIcon)
    }
}