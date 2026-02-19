package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable

@Serializable
data class SocialSystemState(
    var allowReceivingFriendRequests: Boolean = false,
)