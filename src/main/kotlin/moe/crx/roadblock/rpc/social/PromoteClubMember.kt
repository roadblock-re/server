package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PromoteClubMemberRequest(
    var clubId: ClubId,
    var memberCredential: Credentials,
    var memberName: String,
) : RequestPacket()

@Serializable
data class PromoteClubMemberResponse(
    var clubData: ClubData = ClubData()
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePromoteClubMember(
    session: GameConnection,
    request: PromoteClubMemberRequest
) {
    session.sendResponse(PromoteClubMemberResponse())
}