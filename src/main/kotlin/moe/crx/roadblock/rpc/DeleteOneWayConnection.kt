package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.OneWayConnectionParams
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class DeleteOneWayConnectionRequest(
    var connectionParams: OneWayConnectionParams,
) : RequestPacket()

@Serializable
class DeleteOneWayConnectionResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleDeleteOneWayConnection(
    session: GameConnection,
    request: DeleteOneWayConnectionRequest
) {
    session.sendResponse(DeleteOneWayConnectionResponse())
}