package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.club.ClubDonationData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class GetClubDonationsRequest : RequestPacket()

@Serializable
data class GetClubDonationsResponse(
    var donations: List<ClubDonationData> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetClubDonations(
    session: GameConnection,
    request: GetClubDonationsRequest
) {
    session.sendResponse(GetClubDonationsResponse())
}