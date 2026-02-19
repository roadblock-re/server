package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.objects.club.ClubMemberRank
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class KickClubMemberRequest(
    var clubId: ClubId,
    var memberCredential: Credentials,
    var memberName: String,
    var memberRank: ClubMemberRank,
    @UntilVersion("47.1.0")
    var debugSuffix: String = "",
) : RequestPacket()

@Serializable
data class KickClubMemberResponse(
    var clubData: ClubData = ClubData()
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleKickClubMember(
    session: GameConnection,
    request: KickClubMemberRequest
) {
    session.sendResponse(KickClubMemberResponse())
}