package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class GauntletMarketRefreshCheatRequest : RequestPacket()

@Serializable
class GauntletMarketRefreshCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletMarketRefreshCheat(
    session: GameConnection,
    request: GauntletMarketRefreshCheatRequest
) {
    session.sendResponse(GauntletMarketRefreshCheatResponse())
}