package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.RelayOfferTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimAdClientSideRewardsRequest(
    var carIdForRefill: CarId?,
    var specialCalendarEventId: CalendarEventId?,
    var relayOfferTierId: RelayOfferTierId?,
    var rewardName: String,
    var rewardAmount: UInt,
) : RequestPacket()

@Serializable
class ClaimAdClientSideRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimAdClientSideRewards(
    session: GameConnection,
    request: ClaimAdClientSideRewardsRequest
) {
    session.sendResponse(ClaimAdClientSideRewardsResponse())
}