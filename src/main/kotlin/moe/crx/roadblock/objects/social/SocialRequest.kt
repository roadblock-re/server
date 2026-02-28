package moe.crx.roadblock.objects.social

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.FriendRequestId

@Serializable
data class SocialRequest(
    var id: FriendRequestId,
    var creation: Instant,
    var connectionType: String,
    var requesterUserData: OnlineUserData,
    var connectorUserData: OnlineUserData?,
)