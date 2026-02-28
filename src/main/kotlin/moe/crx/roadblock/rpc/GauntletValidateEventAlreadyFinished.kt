package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletValidateEventAlreadyFinishedRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class GauntletValidateEventAlreadyFinishedResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletValidateEventAlreadyFinished(
    session: GameConnection,
    request: GauntletValidateEventAlreadyFinishedRequest
) {
    session.sendResponse(GauntletValidateEventAlreadyFinishedResponse())
}