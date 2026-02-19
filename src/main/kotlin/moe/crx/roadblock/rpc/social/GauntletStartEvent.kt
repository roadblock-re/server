package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.EventTrackDefId
import moe.crx.roadblock.objects.account.GauntletDivision
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletStartEventRequest(
    var eventId: CalendarEventId,
    var cheatTracks: List<EventTrackDefId>,
    var cheatDivision: GauntletDivision,
) : RequestPacket()

@Serializable
class GauntletStartEventResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletStartEvent(
    session: GameConnection,
    request: GauntletStartEventRequest
) {
    session.sendResponse(GauntletStartEventResponse())
}