package moe.crx.roadblock.objects.dailytasks

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class DailyTaskState : RObject {

    var resetTime: Instant = now()
    var completedTaskCount: Int = 0
    var isClaimed: Boolean = false
    var completedTaskGoal: Int = 0
    var rewardType: Int = 0

    override fun read(sink: InputSink) {
        resetTime = sink.readInstant()
        completedTaskCount = sink.readInt()
        isClaimed = sink.readBoolean()
        completedTaskGoal = sink.readInt()
        rewardType = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(resetTime)
        sink.writeInt(completedTaskCount)
        sink.writeBoolean(isClaimed)
        sink.writeInt(completedTaskGoal)
        sink.writeInt(rewardType)
    }
}