package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class VIPBlackMarketGetStatusRequest : RequestPacket()

@Serializable
class VIPBlackMarketGetStatusResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVIPBlackMarketGetStatus(
    session: GameConnection,
    request: VIPBlackMarketGetStatusRequest
) {
    session.sendResponse(VIPBlackMarketGetStatusResponse())
}