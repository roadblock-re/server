package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ClaimDailyVIPFreeGiftRequest : RequestPacket()

@Serializable
class ClaimDailyVIPFreeGiftResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimDailyVIPFreeGift(
    session: GameConnection,
    request: ClaimDailyVIPFreeGiftRequest
) {
    session.sendResponse(ClaimDailyVIPFreeGiftResponse())
}