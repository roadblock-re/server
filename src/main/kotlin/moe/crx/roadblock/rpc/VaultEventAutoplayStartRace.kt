package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.VaultEventId
import moe.crx.roadblock.objects.VaultStageId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultEventAutoplayStartRaceRequest(
    var vaultEventId: VaultEventId,
    var vaultStageId: VaultStageId,
    var quantity: UByte,
) : RequestPacket()

@Serializable
class VaultEventAutoplayStartRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultEventAutoplayStartRace(
    session: GameConnection,
    request: VaultEventAutoplayStartRaceRequest
) {
    session.sendResponse(VaultEventAutoplayStartRaceResponse())
}