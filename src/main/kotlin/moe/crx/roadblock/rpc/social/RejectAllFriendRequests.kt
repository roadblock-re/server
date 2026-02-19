package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.SocialRequest
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class RejectAllFriendRequestsRequest : RequestPacket()

@Serializable
data class RejectAllFriendRequestsResponse(
    var rejectedRequests: List<SocialRequest> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleRejectAllFriendRequests(
    session: GameConnection,
    request: RejectAllFriendRequestsRequest
) {
    session.sendResponse(RejectAllFriendRequestsResponse())
}