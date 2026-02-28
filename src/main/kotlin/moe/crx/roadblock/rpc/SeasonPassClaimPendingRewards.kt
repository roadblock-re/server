package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SeasonPassClaimPendingRewardsRequest(
    var eventId: CalendarEventId,
    var isEndOfEventFinalClaimAll: Boolean,
) : RequestPacket()

@Serializable
class SeasonPassClaimPendingRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSeasonPassClaimPendingRewards(
    session: GameConnection,
    request: SeasonPassClaimPendingRewardsRequest
) {
    session.sendResponse(SeasonPassClaimPendingRewardsResponse())
}