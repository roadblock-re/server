package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.ClubInvitationId
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.objects.club.ClubMemberRank
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class AcceptClubInvitationRequest(
    var invitationId: ClubInvitationId,
    var senderCredential: Credentials,
    var senderRank: ClubMemberRank,
    @UntilVersion("47.1.0")
    var debugSuffix: String = "",
) : RequestPacket()

@Serializable
data class AcceptClubInvitationResponse(
    var clubData: ClubData = ClubData()
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleAcceptClubInvitation(
    session: GameConnection,
    request: AcceptClubInvitationRequest
) {
    session.sendResponse(AcceptClubInvitationResponse())
}