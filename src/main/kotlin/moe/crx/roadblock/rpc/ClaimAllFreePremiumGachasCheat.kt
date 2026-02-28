package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ClaimAllFreePremiumGachasCheatRequest : RequestPacket()

@Serializable
class ClaimAllFreePremiumGachasCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimAllFreePremiumGachasCheat(
    session: GameConnection,
    request: ClaimAllFreePremiumGachasCheatRequest
) {
    session.sendResponse(ClaimAllFreePremiumGachasCheatResponse())
}