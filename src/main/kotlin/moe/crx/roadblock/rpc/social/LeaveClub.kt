package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.club.ClubMemberRank
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class LeaveClubRequest(
    var clubId: ClubId,
    var newManagerCredential: Credentials?,
    var newManagerName: String,
    var newManagerPreviousRank: ClubMemberRank,
    @UntilVersion("47.1.0")
    var debugSuffix: String = "",
) : RequestPacket()

@Serializable
class LeaveClubResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleLeaveClub(
    session: GameConnection,
    request: LeaveClubRequest
) {
    session.sendResponse(LeaveClubResponse())
}