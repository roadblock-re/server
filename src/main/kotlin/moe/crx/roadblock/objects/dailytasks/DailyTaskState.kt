package moe.crx.roadblock.objects.dailytasks

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.DateTimeUnit.Companion.HOUR
import kotlinx.datetime.Instant
import kotlinx.datetime.plus
import kotlinx.serialization.Serializable
import moe.crx.roadblock.core.utils.midnight

@Serializable
data class DailyTaskState(
    var resetTime: Instant = now().midnight().plus(24, HOUR),
    var completedTaskCount: UInt = 0u,
    var isClaimed: Boolean = false,
    var completedTaskGoal: UInt = 2u,
    var rewardType: DailyTaskRaceReadyRewardType = DailyTaskRaceReadyRewardType.LockedCar,
)