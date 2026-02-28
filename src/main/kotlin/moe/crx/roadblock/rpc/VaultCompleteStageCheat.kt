package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.VaultEventId
import moe.crx.roadblock.objects.VaultStageId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultCompleteStageCheatRequest(
    var eventId: VaultEventId,
    var stageId: VaultStageId,
) : RequestPacket()

@Serializable
class VaultCompleteStageCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultCompleteStageCheat(
    session: GameConnection,
    request: VaultCompleteStageCheatRequest
) {
    session.sendResponse(VaultCompleteStageCheatResponse())
}