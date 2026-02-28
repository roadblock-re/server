package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletBuyTicketRequest(
    var eventId: CalendarEventId,
    var price: Money,
) : RequestPacket()

@Serializable
class GauntletBuyTicketResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletBuyTicket(
    session: GameConnection,
    request: GauntletBuyTicketRequest
) {
    session.sendResponse(GauntletBuyTicketResponse())
}