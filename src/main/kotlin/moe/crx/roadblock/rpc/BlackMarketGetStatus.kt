package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BlackMarketGetStatusRequest(
    var shuffleSlots: Boolean,
) : RequestPacket()

@Serializable
class BlackMarketGetStatusResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBlackMarketGetStatus(
    session: GameConnection,
    request: BlackMarketGetStatusRequest
) {
    session.sendResponse(BlackMarketGetStatusResponse())
}