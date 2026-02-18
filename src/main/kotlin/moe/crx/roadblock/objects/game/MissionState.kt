package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MissionState : RObject {

    var isClaimable: Byte = 0
    var value: Int = 0
    var milestone: Short = 0

    override fun read(sink: InputSink) {
        isClaimable = sink.readByte()
        value = sink.readInt()
        milestone = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(isClaimable)
        sink.writeInt(value)
        sink.writeShort(milestone)
    }
}