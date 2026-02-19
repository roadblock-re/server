package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.TLETicket
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventRefillTicketsRequest(
    var amount: TLETicket,
    var free: Boolean,
) : RequestPacket()

@Serializable
class TLEventRefillTicketsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventRefillTickets(
    session: GameConnection,
    request: TLEventRefillTicketsRequest
) {
    session.sendResponse(TLEventRefillTicketsResponse())
}