package moe.crx.roadblock.objects.career

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CareerFlagId

@Serializable
data class EventState(
    var state: ProgressState = ProgressState.Locked,
    var obtainedFlags: List<CareerFlagId> = listOf(),
    var satelliteRewardState: SatelliteRewardState? = null,
)