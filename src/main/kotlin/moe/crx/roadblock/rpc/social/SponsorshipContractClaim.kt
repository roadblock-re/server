package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.SponsorshipContractId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SponsorshipContractClaimRequest(
    var sponsorshipContractId: SponsorshipContractId,
) : RequestPacket()

@Serializable
class SponsorshipContractClaimResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSponsorshipContractClaim(
    session: GameConnection,
    request: SponsorshipContractClaimRequest
) {
    session.sendResponse(SponsorshipContractClaimResponse())
}