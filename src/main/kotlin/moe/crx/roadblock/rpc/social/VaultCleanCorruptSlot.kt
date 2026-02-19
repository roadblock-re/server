package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.VaultSlotId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultCleanCorruptSlotRequest(
    var slotId: VaultSlotId,
) : RequestPacket()

@Serializable
class VaultCleanCorruptSlotResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultCleanCorruptSlot(
    session: GameConnection,
    request: VaultCleanCorruptSlotRequest
) {
    session.sendResponse(VaultCleanCorruptSlotResponse())
}