package moe.crx.roadblock.objects.career

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Flags
import moe.crx.roadblock.objects.game.ProgressState

class CareerChapterState : RObject {

    var state: ProgressState = ProgressState.Locked
    var flags: Flags = 0

    override fun read(sink: InputSink) {
        state = sink.readEnum()
        flags = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(state)
        sink.writeInt(flags)
    }
}