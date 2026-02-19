package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.OnlineUserData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GetClubMembersRequest(
    var clubId: ClubId,
) : RequestPacket()

@Serializable
data class GetClubMembersResponse(
    var members: List<OnlineUserData> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetClubMembers(
    session: GameConnection,
    request: GetClubMembersRequest
) {
    session.sendResponse(GetClubMembersResponse())
}