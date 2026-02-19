package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class DemoteClubMemberRequest(
    var clubId: ClubId,
    var memberCredential: Credentials,
    var memberName: String,
) : RequestPacket()

@Serializable
data class DemoteClubMemberResponse(
    var clubData: ClubData = ClubData()
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleDemoteClubMember(
    session: GameConnection,
    request: DemoteClubMemberRequest
) {
    session.sendResponse(DemoteClubMemberResponse())
}