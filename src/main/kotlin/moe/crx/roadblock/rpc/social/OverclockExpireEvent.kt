package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class OverclockExpireEventRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class OverclockExpireEventResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleOverclockExpireEvent(
    session: GameConnection,
    request: OverclockExpireEventRequest
) {
    session.sendResponse(OverclockExpireEventResponse())
}