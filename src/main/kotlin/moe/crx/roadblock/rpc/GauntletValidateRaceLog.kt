package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletValidateRaceLogRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
data class GauntletValidateRaceLogResponse(
    var needRecreateOpponents: Boolean = false,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletValidateRaceLog(
    session: GameConnection,
    request: GauntletValidateRaceLogRequest
) {
    session.sendResponse(GauntletValidateRaceLogResponse())
}