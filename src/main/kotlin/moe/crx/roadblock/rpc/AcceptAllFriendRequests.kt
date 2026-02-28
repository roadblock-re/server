package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.SocialRequest
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class AcceptAllFriendRequestsRequest : RequestPacket()

@Serializable
data class AcceptAllFriendRequestsResponse(
    var acceptedRequests: List<SocialRequest> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleAcceptAllFriendRequests(
    session: GameConnection,
    request: AcceptAllFriendRequestsRequest
) {
    session.sendResponse(AcceptAllFriendRequestsResponse())
}