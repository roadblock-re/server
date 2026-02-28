package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.OneWayConnectionParams
import moe.crx.roadblock.objects.social.SocialConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ListOneWayConnectionsRequest(
    var connectionParams: OneWayConnectionParams,
) : RequestPacket()

@Serializable
data class ListOneWayConnectionsResponse(
    var connections: List<SocialConnection> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleListOneWayConnections(
    session: GameConnection,
    request: ListOneWayConnectionsRequest
) {
    session.sendResponse(ListOneWayConnectionsResponse())
}