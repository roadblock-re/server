package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.ClubRegionId
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SearchClubsByKeywordsRequest(
    var keyword: String,
    var regionId: ClubRegionId,
) : RequestPacket()

@Serializable
data class SearchClubsByKeywordsResponse(
    var clubsData: List<ClubData> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSearchClubsByKeywords(
    session: GameConnection,
    request: SearchClubsByKeywordsRequest
) {
    session.sendResponse(SearchClubsByKeywordsResponse())
}