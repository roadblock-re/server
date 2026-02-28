package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.SponsorshipContractId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SponsorshipSelectContractRequest(
    var sponsorshipContractId: SponsorshipContractId,
) : RequestPacket()

@Serializable
class SponsorshipSelectContractResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSponsorshipSelectContract(
    session: GameConnection,
    request: SponsorshipSelectContractRequest
) {
    session.sendResponse(SponsorshipSelectContractResponse())
}