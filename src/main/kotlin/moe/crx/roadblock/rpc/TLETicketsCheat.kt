package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.TLETicket
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLETicketsCheatRequest(
    var amount: TLETicket,
) : RequestPacket()

@Serializable
class TLETicketsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLETicketsCheat(
    session: GameConnection,
    request: TLETicketsCheatRequest
) {
    session.sendResponse(TLETicketsCheatResponse())
}