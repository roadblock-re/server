package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.MultiplayerSeriesId
import moe.crx.roadblock.objects.PlayerElo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerSeriesSetEloCheatRequest(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
    var elo: PlayerElo,
) : RequestPacket()

@Serializable
class MultiplayerSeriesSetEloCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesSetEloCheat(
    session: GameConnection,
    request: MultiplayerSeriesSetEloCheatRequest
) {
    session.sendResponse(MultiplayerSeriesSetEloCheatResponse())
}