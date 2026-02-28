package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubRequestId
import moe.crx.roadblock.objects.social.OnlineUserData

@Serializable
data class MembershipRequest(
    var id: ClubRequestId,
    var requester: OnlineUserData,
)