package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventClaimClubRewardRequest(
    var tlEventId: TLEventId,
    var rewardIdx: UByte,
) : RequestPacket()

@Serializable
class TLEventClaimClubRewardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventClaimClubReward(
    session: GameConnection,
    request: TLEventClaimClubRewardRequest
) {
    session.sendResponse(TLEventClaimClubRewardResponse())
}