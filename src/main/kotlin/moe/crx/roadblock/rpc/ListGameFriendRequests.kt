package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.SocialRequest
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ListGameFriendRequestsRequest(
    var showOutgoing: Boolean,
) : RequestPacket()

@Serializable
data class ListGameFriendRequestsResponse(
    var requestsList: List<SocialRequest> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleListGameFriendRequests(
    session: GameConnection,
    request: ListGameFriendRequestsRequest
) {
    session.sendResponse(ListGameFriendRequestsResponse())
}