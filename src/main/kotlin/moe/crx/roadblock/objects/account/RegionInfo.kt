package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class RegionInfo(
    var region: String,
    var controllers: List<PingAddress>,
)