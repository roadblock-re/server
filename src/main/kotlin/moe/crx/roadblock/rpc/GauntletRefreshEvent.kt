package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletRefreshEventRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class GauntletRefreshEventResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletRefreshEvent(
    session: GameConnection,
    request: GauntletRefreshEventRequest
) {
    session.sendResponse(GauntletRefreshEventResponse())
}