package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class Credentials(
    var username: String,
)