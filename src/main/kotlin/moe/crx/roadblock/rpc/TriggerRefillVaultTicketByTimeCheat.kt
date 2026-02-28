package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class TriggerRefillVaultTicketByTimeCheatRequest : RequestPacket()

@Serializable
class TriggerRefillVaultTicketByTimeCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTriggerRefillVaultTicketByTimeCheat(
    session: GameConnection,
    request: TriggerRefillVaultTicketByTimeCheatRequest
) {
    session.sendResponse(TriggerRefillVaultTicketByTimeCheatResponse())
}