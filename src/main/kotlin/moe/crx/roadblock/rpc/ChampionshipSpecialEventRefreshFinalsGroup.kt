package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.championship.ChampionshipGroupMemberData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventRefreshFinalsGroupRequest(
    var eventId: CalendarEventId,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
data class ChampionshipSpecialEventRefreshFinalsGroupResponse(
    var members: List<ChampionshipGroupMemberData> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventRefreshFinalsGroup(
    session: GameConnection,
    request: ChampionshipSpecialEventRefreshFinalsGroupRequest
) {
    session.sendResponse(ChampionshipSpecialEventRefreshFinalsGroupResponse())
}