package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class PingAddress(
    var host: String,
    var port: Int,
)