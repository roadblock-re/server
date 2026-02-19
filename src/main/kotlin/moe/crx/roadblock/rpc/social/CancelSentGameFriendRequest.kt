package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.FriendRequestId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class CancelSentGameFriendRequestRequest(
    var requestId: FriendRequestId,
) : RequestPacket()

@Serializable
class CancelSentGameFriendRequestResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleCancelSentGameFriendRequest(
    session: GameConnection,
    request: CancelSentGameFriendRequestRequest
) {
    session.sendResponse(CancelSentGameFriendRequestResponse())
}