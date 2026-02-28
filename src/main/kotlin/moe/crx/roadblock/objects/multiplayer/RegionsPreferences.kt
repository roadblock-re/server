package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable

@Serializable
data class RegionsPreferences(
    var region: String?,
    var latency: Double?,
)