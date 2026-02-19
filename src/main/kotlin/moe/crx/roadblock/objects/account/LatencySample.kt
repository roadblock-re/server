package moe.crx.roadblock.objects.account

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class LatencySample(
    var info: LatencyInfo,
    var ts: Instant,
)