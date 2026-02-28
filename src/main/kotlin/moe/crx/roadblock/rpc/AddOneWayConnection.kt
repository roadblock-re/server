package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.FriendRequestId
import moe.crx.roadblock.objects.social.OneWayConnectionParams
import moe.crx.roadblock.objects.social.SocialConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class AddOneWayConnectionRequest(
    var connectionParams: OneWayConnectionParams,
) : RequestPacket()

@Serializable
data class AddOneWayConnectionResponse(
    var connectionMain: SocialConnection,
    var connectionReverse: SocialConnection? = null,
    var didRejectFriendRequest: FriendRequestId? = null,
    var didCancelSentRequest: FriendRequestId? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleAddOneWayConnection(
    session: GameConnection,
    request: AddOneWayConnectionRequest
) {
    TODO()
}