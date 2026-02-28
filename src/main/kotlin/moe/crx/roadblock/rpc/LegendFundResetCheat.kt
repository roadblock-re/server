package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class LegendFundResetCheatRequest : RequestPacket()

@Serializable
class LegendFundResetCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleLegendFundResetCheat(
    session: GameConnection,
    request: LegendFundResetCheatRequest
) {
    session.sendResponse(LegendFundResetCheatResponse())
}