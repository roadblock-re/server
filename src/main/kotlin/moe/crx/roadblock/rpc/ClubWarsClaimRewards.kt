package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsClaimRewardsRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class ClubWarsClaimRewardsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsClaimRewards(
    session: GameConnection,
    request: ClubWarsClaimRewardsRequest
) {
    session.sendResponse(ClubWarsClaimRewardsResponse())
}