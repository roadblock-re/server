package moe.crx.roadblock.game.handlers

import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.request.GetClubInvitationsRequest
import moe.crx.roadblock.rpc.response.GetClubInvitationsResponse

suspend fun handleGetClubInvitations(
    session: GameConnection,
    request: GetClubInvitationsRequest
) {
    session.send(GetClubInvitationsResponse())
}