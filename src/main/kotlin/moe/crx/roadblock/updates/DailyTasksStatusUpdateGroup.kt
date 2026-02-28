package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.dailytasks.DailyTaskRaceReadyRewardType
import moe.crx.roadblock.objects.dailytasks.DailyTaskType

@Serializable
sealed class DailyTasksStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<DailyTasksStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(DailyTasksReseted::class)
            add(DailyTasksTaskUnlocked::class)
            add(DailyTasksTaskIncreased::class)
            add(DailyTasksTaskCompleted::class)
            add(DailyTasksTaskClaimed::class)
            add(DailyTasksTaskEnabled::class)
            add(DailyTasksRaceReadyCompleted::class)
            add(DailyTasksRaceReadyClaimed::class)
        }
    }
}

@Serializable
class DailyTasksRaceReadyClaimed : DailyTasksStatusUpdateGroup()

@Serializable
class DailyTasksRaceReadyCompleted : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksReseted(
    var rewardType: DailyTaskRaceReadyRewardType,
    var completedTaskGoal: UInt,
    var nextResetTime: Instant,
    var isSpecialEventActive: Boolean,
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskClaimed(
    @ByteEnum
    var type: DailyTaskType
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskCompleted(
    @ByteEnum
    var type: DailyTaskType
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskEnabled(
    @ByteEnum
    var type: DailyTaskType
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskIncreased(
    @ByteEnum
    var type: DailyTaskType,
    var amount: UInt,
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskUnlocked(
    @ByteEnum
    var type: DailyTaskType
) : DailyTasksStatusUpdateGroup()