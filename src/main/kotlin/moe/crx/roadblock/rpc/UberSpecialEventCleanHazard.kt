package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UberSpecialEventCleanHazardRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class UberSpecialEventCleanHazardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUberSpecialEventCleanHazard(
    session: GameConnection,
    request: UberSpecialEventCleanHazardRequest
) {
    session.sendResponse(UberSpecialEventCleanHazardResponse())
}