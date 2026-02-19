package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.ClubDonationItemId
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GiveClubDonationRequest(
    var templateId: String,
    var playerCredentials: Credentials,
    var itemId: ClubDonationItemId,
    var amount: UInt
) : RequestPacket()

@Serializable
class GiveClubDonationResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGiveClubDonation(
    session: GameConnection,
    request: GiveClubDonationRequest
) {
    session.sendResponse(GiveClubDonationResponse())
}