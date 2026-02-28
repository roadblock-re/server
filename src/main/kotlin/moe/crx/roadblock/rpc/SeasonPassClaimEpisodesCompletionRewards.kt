package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SeasonPassClaimEpisodesCompletionRewardsRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class SeasonPassClaimEpisodesCompletionRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSeasonPassClaimEpisodesCompletionRewards(
    session: GameConnection,
    request: SeasonPassClaimEpisodesCompletionRewardsRequest
) {
    session.sendResponse(SeasonPassClaimEpisodesCompletionRewardsResponse())
}