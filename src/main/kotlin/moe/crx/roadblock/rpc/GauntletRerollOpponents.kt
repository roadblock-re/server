package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletRerollOpponentsRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class GauntletRerollOpponentsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletRerollOpponents(
    session: GameConnection,
    request: GauntletRerollOpponentsRequest
) {
    session.sendResponse(GauntletRerollOpponentsResponse())
}