package moe.crx.roadblock.objects.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.OnlineUserData

@Serializable
data class SocialConnection(
    var onlineUserData: OnlineUserData,
)