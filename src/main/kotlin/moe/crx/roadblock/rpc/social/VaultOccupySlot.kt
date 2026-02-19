package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.VaultEventId
import moe.crx.roadblock.objects.account.VaultSlotId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultOccupySlotRequest(
    var slotId: VaultSlotId,
    var eventId: VaultEventId,
) : RequestPacket()

@Serializable
class VaultOccupySlotResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultOccupySlot(
    session: GameConnection,
    request: VaultOccupySlotRequest
) {
    session.sendResponse(VaultOccupySlotResponse())
}