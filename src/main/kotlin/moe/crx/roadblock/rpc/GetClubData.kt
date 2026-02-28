package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GetClubDataRequest(
    var clubId: ClubId
) : RequestPacket()

@Serializable
data class GetClubDataResponse(
    var clubData: ClubData = ClubData(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetClubData(
    session: GameConnection,
    request: GetClubDataRequest
) {
    session.sendResponse(GetClubDataResponse())
}