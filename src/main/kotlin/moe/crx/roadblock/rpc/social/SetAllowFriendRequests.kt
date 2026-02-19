package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SetAllowFriendRequestsRequest(
    var allowRequests: Boolean,
) : RequestPacket()

@Serializable
class SetAllowFriendRequestsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSetAllowFriendRequests(
    session: GameConnection,
    request: SetAllowFriendRequestsRequest
) {
    session.sendResponse(SetAllowFriendRequestsResponse())
}