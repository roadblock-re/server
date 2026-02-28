package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsRefreshClaimStateRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class ClubWarsRefreshClaimStateResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsRefreshClaimState(
    session: GameConnection,
    request: ClubWarsRefreshClaimStateRequest
) {
    session.sendResponse(ClubWarsRefreshClaimStateResponse())
}