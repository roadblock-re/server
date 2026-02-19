package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.tracking.TrackingEvent
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket

@Serializable
data class SendTrackingEventsRequest(
    var events: List<TrackingEvent>,
) : RequestPacket()

@Serializable
class SendTrackingEventsResponse : ResponsePacket()

suspend fun handleSendTrackingEvents(session: GameConnection, request: SendTrackingEventsRequest) {
    session.sendResponse(SendTrackingEventsResponse())
}