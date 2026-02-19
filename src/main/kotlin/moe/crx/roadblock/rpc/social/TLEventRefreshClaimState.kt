package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventRefreshClaimStateRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class TLEventRefreshClaimStateResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventRefreshClaimState(
    session: GameConnection,
    request: TLEventRefreshClaimStateRequest
) {
    session.sendResponse(TLEventRefreshClaimStateResponse())
}