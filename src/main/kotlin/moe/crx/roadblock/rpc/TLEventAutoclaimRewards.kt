package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventAutoclaimRewardsRequest(
    var tlEventId: TLEventId,
) : RequestPacket()

@Serializable
class TLEventAutoclaimRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventAutoclaimRewards(
    session: GameConnection,
    request: TLEventAutoclaimRewardsRequest
) {
    session.sendResponse(TLEventAutoclaimRewardsResponse())
}