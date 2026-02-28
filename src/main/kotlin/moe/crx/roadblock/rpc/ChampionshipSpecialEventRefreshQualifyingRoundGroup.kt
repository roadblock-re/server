package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ChampionshipRoundId
import moe.crx.roadblock.objects.championship.ChampionshipGroupMemberData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventRefreshQualifyingRoundGroupRequest(
    var eventId: CalendarEventId,
    var roundId: ChampionshipRoundId,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
data class ChampionshipSpecialEventRefreshQualifyingRoundGroupResponse(
    var members: List<ChampionshipGroupMemberData> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventRefreshQualifyingRoundGroup(
    session: GameConnection,
    request: ChampionshipSpecialEventRefreshQualifyingRoundGroupRequest
) {
    session.sendResponse(ChampionshipSpecialEventRefreshQualifyingRoundGroupResponse())
}