package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UberSpecialEventFinalClaimRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class UberSpecialEventFinalClaimResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUberSpecialEventFinalClaim(
    session: GameConnection,
    request: UberSpecialEventFinalClaimRequest
) {
    session.sendResponse(UberSpecialEventFinalClaimResponse())
}