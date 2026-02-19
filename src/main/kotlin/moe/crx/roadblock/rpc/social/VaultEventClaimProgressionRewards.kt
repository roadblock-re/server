package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.VaultEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultEventClaimProgressionRewardsRequest(
    var eventId: VaultEventId,
    var rewardIdxs: List<UByte>,
) : RequestPacket()

@Serializable
class VaultEventClaimProgressionRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultEventClaimProgressionRewards(
    session: GameConnection,
    request: VaultEventClaimProgressionRewardsRequest
) {
    session.sendResponse(VaultEventClaimProgressionRewardsResponse())
}