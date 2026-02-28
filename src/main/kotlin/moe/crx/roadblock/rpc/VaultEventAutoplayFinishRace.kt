package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.VaultEventId
import moe.crx.roadblock.objects.VaultStageId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultEventAutoplayFinishRaceRequest(
    var vaultEventId: VaultEventId,
    var vaultStageId: VaultStageId,
) : RequestPacket()

@Serializable
class VaultEventAutoplayFinishRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultEventAutoplayFinishRace(
    session: GameConnection,
    request: VaultEventAutoplayFinishRaceRequest
) {
    session.sendResponse(VaultEventAutoplayFinishRaceResponse())
}