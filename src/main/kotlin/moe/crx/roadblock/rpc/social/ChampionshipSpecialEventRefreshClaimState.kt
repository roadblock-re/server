package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventRefreshClaimStateRequest(
    var eventId: CalendarEventId,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ChampionshipSpecialEventRefreshClaimStateResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventRefreshClaimState(
    session: GameConnection,
    request: ChampionshipSpecialEventRefreshClaimStateRequest
) {
    session.sendResponse(ChampionshipSpecialEventRefreshClaimStateResponse())
}