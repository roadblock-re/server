package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.SeasonPassEpisodeId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SeasonPassClaimEpisodePartialCompletionRewardsRequest(
    var eventId: CalendarEventId,
    var episodeId: SeasonPassEpisodeId,
) : RequestPacket()

@Serializable
class SeasonPassClaimEpisodePartialCompletionRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSeasonPassClaimEpisodePartialCompletionRewards(
    session: GameConnection,
    request: SeasonPassClaimEpisodePartialCompletionRewardsRequest
) {
    session.sendResponse(SeasonPassClaimEpisodePartialCompletionRewardsResponse())
}