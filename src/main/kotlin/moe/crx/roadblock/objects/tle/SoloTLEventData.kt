package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion

@Serializable
data class SoloTLEventData(
    var obtainedRewardCounts: List<UInt>,
    @FromVersion("24.6.0")
    var cumulativeRewardData: Map<UInt, Map<UInt, UInt>> = mapOf(),
)