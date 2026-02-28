package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.SponsorshipContractId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SponsorshipContractFailRequest(
    var sponsorshipContractId: SponsorshipContractId,
) : RequestPacket()

@Serializable
class SponsorshipContractFailResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSponsorshipContractFail(
    session: GameConnection,
    request: SponsorshipContractFailRequest
) {
    session.sendResponse(SponsorshipContractFailResponse())
}