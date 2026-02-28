package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.FriendRequestId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class RejectGameFriendRequestRequest(
    var requestId: FriendRequestId,
) : RequestPacket()

@Serializable
class RejectGameFriendResponseRequest : UpdatesQueueWithRootReactionsResponse()

suspend fun handleRejectGameFriendRequest(
    session: GameConnection,
    request: RejectGameFriendRequestRequest
) {
    session.sendResponse(RejectGameFriendResponseRequest())
}