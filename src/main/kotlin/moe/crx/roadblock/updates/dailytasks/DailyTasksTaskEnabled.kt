package moe.crx.roadblock.updates.dailytasks

import moe.crx.roadblock.game.io.EnumIO.readEnum8
import moe.crx.roadblock.game.io.EnumIO.writeEnum8
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.DailyTaskType

class DailyTasksTaskEnabled : RObject {

    var type: DailyTaskType = DailyTaskType.ClaimCardPacks

    override fun read(sink: InputSink) {
        type = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum8(type)
    }
}