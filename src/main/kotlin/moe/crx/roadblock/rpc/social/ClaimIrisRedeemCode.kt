package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimIrisRedeemCodeRequest(
    var code: String,
) : RequestPacket()

@Serializable
class ClaimIrisRedeemCodeResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimIrisRedeemCode(
    session: GameConnection,
    request: ClaimIrisRedeemCodeRequest
) {
    session.sendResponse(ClaimIrisRedeemCodeResponse())
}