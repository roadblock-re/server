package moe.crx.roadblock.updates.dailytasks

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.DailyTaskType

class DailyTasksTaskIncreased : RObject {

    var type: DailyTaskType = DailyTaskType.ClaimCardPacks
    var amount: Int = 0

    override fun read(sink: InputSink) {
        type = sink.readEnum8()
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum8(type)
        sink.writeInt(amount)
    }
}