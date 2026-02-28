package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.GauntletDivision
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletResetEventStateRequest(
    var eventId: CalendarEventId,
    var cheatTracks: List<EventTrackDefId>,
    var cheatDivision: GauntletDivision,
) : RequestPacket()

@Serializable
class GauntletResetEventStateResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletResetEventState(
    session: GameConnection,
    request: GauntletResetEventStateRequest
) {
    session.sendResponse(GauntletResetEventStateResponse())
}