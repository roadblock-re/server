package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.FriendRequestId
import moe.crx.roadblock.objects.social.SocialRequest
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class AcceptGameFriendRequestRequest(
    var requestId: FriendRequestId,
) : RequestPacket()

@Serializable
data class AcceptGameFriendResponseRequest(
    var request: SocialRequest,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleAcceptGameFriendRequest(
    session: GameConnection,
    request: AcceptGameFriendRequestRequest
) {
    TODO()
}