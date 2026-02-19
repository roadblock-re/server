package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventClaimRankRewardsRequest(
    var tlEventId: TLEventId,
) : RequestPacket()

@Serializable
class TLEventClaimRankRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventClaimRankRewards(
    session: GameConnection,
    request: TLEventClaimRankRewardsRequest
) {
    session.sendResponse(TLEventClaimRankRewardsResponse())
}