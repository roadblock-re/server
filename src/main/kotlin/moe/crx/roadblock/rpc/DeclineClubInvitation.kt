package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.ClubInvitationId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class DeclineClubInvitationRequest(
    var invitationIds: List<ClubInvitationId>,
) : RequestPacket()

@Serializable
class DeclineClubInvitationResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleDeclineClubInvitation(
    session: GameConnection,
    request: DeclineClubInvitationRequest
) {
    session.sendResponse(DeclineClubInvitationResponse())
}