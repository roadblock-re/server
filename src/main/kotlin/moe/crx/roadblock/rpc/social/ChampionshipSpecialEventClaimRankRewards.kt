package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventClaimRankRewardsRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class ChampionshipSpecialEventClaimRankRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventClaimRankRewards(
    session: GameConnection,
    request: ChampionshipSpecialEventClaimRankRewardsRequest
) {
    session.sendResponse(ChampionshipSpecialEventClaimRankRewardsResponse())
}