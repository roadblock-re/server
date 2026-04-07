package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.dailytasks.DailyTaskRaceReadyRewardType
import moe.crx.roadblock.objects.dailytasks.DailyTaskType

@Serializable
sealed class DailyTasksStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<DailyTasksStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(DailyTasksReset::class) // DailyTasksReseted
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
data class DailyTasksReset(
    var rewardType: DailyTaskRaceReadyRewardType,
    var completedTaskGoal: UInt,
    var nextResetTime: Instant,
    var isSpecialEventActive: Boolean,
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskUnlocked(
    @UntilVersion("24.0.0") @ByteEnum // TODO find exact version
    var legacyType: DailyTaskType = DailyTaskType.ClaimCardPacks,
    var type: DailyTaskType = DailyTaskType.ClaimCardPacks,
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskIncreased(
    @UntilVersion("24.0.0") @ByteEnum // TODO find exact version
    var legacyType: DailyTaskType = DailyTaskType.ClaimCardPacks,
    var type: DailyTaskType = DailyTaskType.ClaimCardPacks,
    var amount: UInt,
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskCompleted(
    @UntilVersion("24.0.0") @ByteEnum // TODO find exact version
    var legacyType: DailyTaskType = DailyTaskType.ClaimCardPacks,
    var type: DailyTaskType = DailyTaskType.ClaimCardPacks,
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskClaimed(
    @UntilVersion("24.0.0") @ByteEnum // TODO find exact version
    var legacyType: DailyTaskType = DailyTaskType.ClaimCardPacks,
    var type: DailyTaskType = DailyTaskType.ClaimCardPacks,
) : DailyTasksStatusUpdateGroup()

@Serializable
data class DailyTasksTaskEnabled(
    @UntilVersion("24.0.0") @ByteEnum // TODO find exact version
    var legacyType: DailyTaskType = DailyTaskType.ClaimCardPacks,
    var type: DailyTaskType = DailyTaskType.ClaimCardPacks,
) : DailyTasksStatusUpdateGroup()

@Serializable
class DailyTasksRaceReadyCompleted : DailyTasksStatusUpdateGroup()

@Serializable
class DailyTasksRaceReadyClaimed : DailyTasksStatusUpdateGroup()