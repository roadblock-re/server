package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletFinalClaimRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class GauntletFinalClaimResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletFinalClaim(
    session: GameConnection,
    request: GauntletFinalClaimRequest
) {
    session.sendResponse(GauntletFinalClaimResponse())
}