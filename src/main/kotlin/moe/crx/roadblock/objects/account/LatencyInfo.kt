package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class LatencyInfo(
    var latency: Double,
)