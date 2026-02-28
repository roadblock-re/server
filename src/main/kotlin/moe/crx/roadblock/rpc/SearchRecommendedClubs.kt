package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.ClubRegionId
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.objects.club.ClubMembershipType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SearchRecommendedClubsRequest(
    var membershipType: ClubMembershipType,
    var regionId: ClubRegionId,
) : RequestPacket()

@Serializable
data class SearchRecommendedClubsResponse(
    var clubsData: List<ClubData> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSearchRecommendedClubs(
    session: GameConnection,
    request: SearchRecommendedClubsRequest
) {
    session.sendResponse(SearchRecommendedClubsResponse())
}