package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class RegionsPreferences(
    var region: String?,
    var latency: Double?,
)