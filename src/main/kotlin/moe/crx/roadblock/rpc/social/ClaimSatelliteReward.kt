package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CareerEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimSatelliteRewardRequest(
    var eventId: CareerEventId,
) : RequestPacket()

@Serializable
class ClaimSatelliteRewardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimSatelliteReward(
    session: GameConnection,
    request: ClaimSatelliteRewardRequest
) {
    session.sendResponse(ClaimSatelliteRewardResponse())
}