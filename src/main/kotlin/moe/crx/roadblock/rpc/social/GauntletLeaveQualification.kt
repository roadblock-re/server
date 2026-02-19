package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletLeaveQualificationRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class GauntletLeaveQualificationResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletLeaveQualification(
    session: GameConnection,
    request: GauntletLeaveQualificationRequest
) {
    session.sendResponse(GauntletLeaveQualificationResponse())
}