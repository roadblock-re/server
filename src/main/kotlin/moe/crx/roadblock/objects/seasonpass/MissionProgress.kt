package moe.crx.roadblock.objects.seasonpass

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MissionProgress : RObject {

    var progressVariant: Byte = 0
    var progress: Int = 0

    override fun read(sink: InputSink) {
        progressVariant = sink.readByte()
        progress = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(progressVariant)
        sink.writeInt(progress)
    }
}