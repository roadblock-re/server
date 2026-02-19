package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SearchClubByTagRequest(
    var tag: String,
) : RequestPacket()

@Serializable
data class SearchClubByTagResponse(
    var clubData: ClubData? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSearchClubByTag(
    session: GameConnection,
    request: SearchClubByTagRequest
) {
    session.sendResponse(SearchClubByTagResponse())
}