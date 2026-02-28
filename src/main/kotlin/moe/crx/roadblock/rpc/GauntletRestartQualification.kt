package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletRestartQualificationRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class GauntletRestartQualificationResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletRestartQualification(
    session: GameConnection,
    request: GauntletRestartQualificationRequest
) {
    session.sendResponse(GauntletRestartQualificationResponse())
}