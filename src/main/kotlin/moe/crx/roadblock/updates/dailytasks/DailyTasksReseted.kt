package moe.crx.roadblock.updates.dailytasks

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.dailytasks.DailyTaskRaceReadyRewardType

class DailyTasksReseted : RObject {

    var rewardType: DailyTaskRaceReadyRewardType = DailyTaskRaceReadyRewardType.LockedCar
    var completedTaskGoal: Int = 0
    var nextResetTime: Instant = now()
    var isSpecialEventActive: Boolean = false

    override fun read(sink: InputSink) {
        rewardType = sink.readEnum()
        completedTaskGoal = sink.readInt()
        nextResetTime = sink.readInstant()
        isSpecialEventActive = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(rewardType)
        sink.writeInt(completedTaskGoal)
        sink.writeInstant(nextResetTime)
        sink.writeBoolean(isSpecialEventActive)
    }
}