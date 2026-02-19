package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.ChampionshipRoundId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventRefreshFinalsRoundStateRequest(
    var eventId: CalendarEventId,
    var roundId: ChampionshipRoundId,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ChampionshipSpecialEventRefreshFinalsRoundStateResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventRefreshFinalsRoundState(
    session: GameConnection,
    request: ChampionshipSpecialEventRefreshFinalsRoundStateRequest
) {
    session.sendResponse(ChampionshipSpecialEventRefreshFinalsRoundStateResponse())
}