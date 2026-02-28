package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.ClubRegionId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.objects.club.ClubLogo
import moe.crx.roadblock.objects.club.ClubMembershipType
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class CreateClubRequest(
    var name: String,
    var motto: String,
    var logo: ClubLogo,
    var regionId: ClubRegionId,
    var membershipType: ClubMembershipType,
    var currencyType: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
data class CreateClubResponse(
    var clubData: ClubData = ClubData()
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleCreateClub(
    session: GameConnection,
    request: CreateClubRequest
) {
    session.sendResponse(CreateClubResponse())
}