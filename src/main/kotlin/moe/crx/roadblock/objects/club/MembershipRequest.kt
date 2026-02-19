package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ClubRequestId
import moe.crx.roadblock.objects.account.OnlineUserData

@Serializable
data class MembershipRequest(
    var id: ClubRequestId,
    var requester: OnlineUserData,
)