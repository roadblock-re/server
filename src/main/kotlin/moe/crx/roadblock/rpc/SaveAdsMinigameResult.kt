package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SaveAdsMinigameResultRequest(
    var multiplierFactor: UInt,
) : RequestPacket()

@Serializable
class SaveAdsMinigameResultResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSaveAdsMinigameResult(
    session: GameConnection,
    request: SaveAdsMinigameResultRequest
) {
    session.sendResponse(SaveAdsMinigameResultResponse())
}