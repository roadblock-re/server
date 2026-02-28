package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.VaultTicket
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ConsumeVaultTicketCheatRequest(
    var amount: VaultTicket,
) : RequestPacket()

@Serializable
class ConsumeVaultTicketCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleConsumeVaultTicketCheat(
    session: GameConnection,
    request: ConsumeVaultTicketCheatRequest
) {
    session.sendResponse(ConsumeVaultTicketCheatResponse())
}