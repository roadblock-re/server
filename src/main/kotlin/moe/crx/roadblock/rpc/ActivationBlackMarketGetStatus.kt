package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ActivationBlackMarketGetStatusRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class ActivationBlackMarketGetStatusResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleActivationBlackMarketGetStatus(
    session: GameConnection,
    request: ActivationBlackMarketGetStatusRequest
) {
    session.sendResponse(ActivationBlackMarketGetStatusResponse())
}