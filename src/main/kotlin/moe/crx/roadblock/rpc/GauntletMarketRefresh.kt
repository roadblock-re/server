package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class GauntletMarketRefreshRequest : RequestPacket()

@Serializable
class GauntletMarketRefreshResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletMarketRefresh(
    session: GameConnection,
    request: GauntletMarketRefreshRequest
) {
    session.sendResponse(GauntletMarketRefreshResponse())
}