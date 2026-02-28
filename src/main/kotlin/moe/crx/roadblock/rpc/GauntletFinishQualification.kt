package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletFinishQualificationRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class GauntletFinishQualificationResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletFinishQualification(
    session: GameConnection,
    request: GauntletFinishQualificationRequest
) {
    session.sendResponse(GauntletFinishQualificationResponse())
}