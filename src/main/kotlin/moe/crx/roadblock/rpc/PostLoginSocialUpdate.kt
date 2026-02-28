package moe.crx.roadblock.rpc

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.social.SocialConnection
import moe.crx.roadblock.objects.social.SocialRequest
import moe.crx.roadblock.objects.social.SocialUpdateReason
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PostLoginSocialUpdateRequest(
    var reason: SocialUpdateReason,
    var debugEnableAlerts: Boolean,
    @FromVersion("45.0.0")
    var platformHasPlatformUsersList: Boolean = false,
) : RequestPacket()

@Serializable
data class PostLoginSocialUpdateResponse(
    var friendsList: List<SocialConnection>? = listOf(),
    var friendRequestsList: List<SocialRequest>? = listOf(),
    var sentFriendRequestsList: List<SocialRequest>? = listOf(),
    var blockedList: List<SocialConnection>? = listOf(),
    var blockedByList: List<SocialConnection>? = listOf(),
    var recentlyPlayedWithUsers: List<SocialConnection>? = listOf(),
    var recentlyPlayedWithUsersTimepoint: Instant = now(),
    var nextRefreshTime: UInt = UInt.MAX_VALUE,
    var nextUpdateOnlineStatusTime: UInt = UInt.MAX_VALUE,
    var minimumTimeBetweenPlatformUsersRefreshes: UInt = UInt.MAX_VALUE,
    var requestSocialProfileCooldownTime: UInt = UInt.MAX_VALUE,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePostLoginSocialUpdate(
    session: GameConnection,
    request: PostLoginSocialUpdateRequest
) {
    session.sendResponse(PostLoginSocialUpdateResponse())
}