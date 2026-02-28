package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.VaultTicket
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class IncreaseVaultTicketCheatRequest(
    var amount: VaultTicket,
) : RequestPacket()

@Serializable
class IncreaseVaultTicketCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleIncreaseVaultTicketCheat(
    session: GameConnection,
    request: IncreaseVaultTicketCheatRequest
) {
    session.sendResponse(IncreaseVaultTicketCheatResponse())
}