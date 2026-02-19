package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.VaultEventId
import moe.crx.roadblock.objects.account.VaultStageId
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