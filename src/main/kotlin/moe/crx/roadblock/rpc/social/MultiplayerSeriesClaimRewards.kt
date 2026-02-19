package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.MultiplayerSeriesId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerSeriesClaimRewardsRequest(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class MultiplayerSeriesClaimRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesClaimRewards(
    session: GameConnection,
    request: MultiplayerSeriesClaimRewardsRequest
) {
    session.sendResponse(MultiplayerSeriesClaimRewardsResponse())
}