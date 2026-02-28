package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.MultiplayerSeriesId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerSeriesResetMaxTierCheatRequest(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class MultiplayerSeriesResetMaxTierCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesResetMaxTierCheat(
    session: GameConnection,
    request: MultiplayerSeriesResetMaxTierCheatRequest
) {
    session.sendResponse(MultiplayerSeriesResetMaxTierCheatResponse())
}