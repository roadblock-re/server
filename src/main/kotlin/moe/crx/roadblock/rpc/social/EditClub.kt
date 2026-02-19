package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.ClubRegionId
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.objects.club.ClubLogo
import moe.crx.roadblock.objects.club.ClubMembershipType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class EditClubRequest(
    var clubId: ClubId,
    var name: String,
    var motto: String,
    var logo: ClubLogo,
    var regionId: ClubRegionId,
    var membershipType: ClubMembershipType,
) : RequestPacket()

@Serializable
data class EditClubResponse(
    var clubData: ClubData = ClubData()
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleEditClub(
    session: GameConnection,
    request: EditClubRequest
) {
    session.sendResponse(EditClubResponse())
}