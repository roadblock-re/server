package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimSponsorshipGachaBoxRequest(
    var boxesToOpenCount: UInt,
    var compactRewards: Boolean,
) : RequestPacket()

@Serializable
class ClaimSponsorshipGachaBoxResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimSponsorshipGachaBox(
    session: GameConnection,
    request: ClaimSponsorshipGachaBoxRequest
) {
    session.sendResponse(ClaimSponsorshipGachaBoxResponse())
}