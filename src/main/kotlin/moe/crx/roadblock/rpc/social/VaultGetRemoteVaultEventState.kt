package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.VaultEventId
import moe.crx.roadblock.objects.vault.EventRewardsIndexesState
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultGetRemoteVaultEventStateRequest(
    var eventId: VaultEventId,
) : RequestPacket()

@Serializable
data class VaultGetRemoteVaultEventStateResponse(
    var indexesState: EventRewardsIndexesState? = null
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultGetRemoteVaultEventState(
    session: GameConnection,
    request: VaultGetRemoteVaultEventStateRequest
) {
    session.sendResponse(VaultGetRemoteVaultEventStateResponse())
}