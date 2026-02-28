package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.club.ClubInvitation
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GetClubInvitationsRequest(
    var limit: UInt,
) : RequestPacket()

@Serializable
data class GetClubInvitationsResponse(
    var requests: List<ClubInvitation> = listOf()
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetClubInvitations(
    session: GameConnection,
    request: GetClubInvitationsRequest
) {
    session.sendResponse(GetClubInvitationsResponse())
}