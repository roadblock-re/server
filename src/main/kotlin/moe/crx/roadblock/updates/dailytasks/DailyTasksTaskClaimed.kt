package moe.crx.roadblock.updates.dailytasks

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.DailyTaskType

class DailyTasksTaskClaimed : RObject {

    var type: DailyTaskType = DailyTaskType.ClaimCardPacks

    override fun read(sink: InputSink) {
        type = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum8(type)
    }
}