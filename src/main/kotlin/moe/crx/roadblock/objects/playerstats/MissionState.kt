package moe.crx.roadblock.objects.playerstats

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.MissionMilestone
import moe.crx.roadblock.objects.MissionValue

@Serializable
data class MissionState(
    var isClaimable: Boolean = false,
    var value: MissionValue = 0u,
    var milestone: MissionMilestone = 0u,
)