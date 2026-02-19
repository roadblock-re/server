package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class GetXuidsRequest : RequestPacket() // TODO I'm not sure about that.

@Serializable
data class GetXuidsResponse(
    var xuids: List<String> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetXuids(
    session: GameConnection,
    request: GetXuidsRequest
) {
    session.sendResponse(GetXuidsResponse())
}