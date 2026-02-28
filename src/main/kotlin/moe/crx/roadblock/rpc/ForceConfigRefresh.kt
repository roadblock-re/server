package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ForceConfigRefreshRequest : RequestPacket()

@Serializable
class ForceConfigRefreshResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleForceConfigRefresh(
    session: GameConnection,
    request: ForceConfigRefreshRequest
) {
    session.sendResponse(ForceConfigRefreshResponse())
}