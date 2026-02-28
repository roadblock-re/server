package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.TimeLimitedEventProgressionLevel

@Serializable
data class TimeLimitedSpecialData(
    var progressionLevels: List<TimeLimitedEventProgressionLevel>,
    var progressionRewardStates: List<TimeLimitedSpecialProgressionRewardState>,
)