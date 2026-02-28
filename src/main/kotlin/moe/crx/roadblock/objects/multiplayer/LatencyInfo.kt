package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable

@Serializable
data class LatencyInfo(
    var latency: Double,
)