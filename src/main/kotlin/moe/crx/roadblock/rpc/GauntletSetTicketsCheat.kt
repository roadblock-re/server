package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletSetTicketsCheatRequest(
    var eventId: CalendarEventId,
    var amount: UShort,
) : RequestPacket()

@Serializable
class GauntletSetTicketsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletSetTicketsCheat(
    session: GameConnection,
    request: GauntletSetTicketsCheatRequest
) {
    session.sendResponse(GauntletSetTicketsCheatResponse())
}