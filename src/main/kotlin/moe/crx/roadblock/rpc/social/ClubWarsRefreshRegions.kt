package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.ClubWarsRegionId
import moe.crx.roadblock.objects.account.ClubWarsRoundIndex
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsRefreshRegionsRequest(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var regionsIds: List<ClubWarsRegionId>,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsRefreshRegionsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsRefreshRegions(
    session: GameConnection,
    request: ClubWarsRefreshRegionsRequest
) {
    session.sendResponse(ClubWarsRefreshRegionsResponse())
}