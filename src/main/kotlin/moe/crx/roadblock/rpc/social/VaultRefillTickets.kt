package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.VaultTicket
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultRefillTicketsRequest(
    var amount: VaultTicket,
    var isFree: Boolean,
) : RequestPacket()

@Serializable
class VaultRefillTicketsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultRefillTickets(
    session: GameConnection,
    request: VaultRefillTicketsRequest
) {
    session.sendResponse(VaultRefillTicketsResponse())
}