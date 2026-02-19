package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.VaultEventId
import moe.crx.roadblock.objects.account.VaultStageId
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