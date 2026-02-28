package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.VaultSlotId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultDeoccupySlotRequest(
    var slotId: VaultSlotId,
) : RequestPacket()

@Serializable
class VaultDeoccupySlotResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultDeoccupySlot(
    session: GameConnection,
    request: VaultDeoccupySlotRequest
) {
    session.sendResponse(VaultDeoccupySlotResponse())
}