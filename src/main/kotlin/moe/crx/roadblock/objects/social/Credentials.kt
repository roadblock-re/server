package moe.crx.roadblock.objects.social

import kotlinx.serialization.Serializable

@Serializable
data class Credentials(
    var username: String,
)