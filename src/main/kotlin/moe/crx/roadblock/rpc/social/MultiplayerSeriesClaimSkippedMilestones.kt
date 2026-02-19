package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.MultiplayerSeriesId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerSeriesClaimSkippedMilestonesRequest(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class MultiplayerSeriesClaimSkippedMilestonesResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesClaimSkippedMilestones(
    session: GameConnection,
    request: MultiplayerSeriesClaimSkippedMilestonesRequest
) {
    session.sendResponse(MultiplayerSeriesClaimSkippedMilestonesResponse())
}