package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ClubWarsRoundIndex
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsRefreshNodesRequest(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var nodeIds: List<ClubWarsNodeId>,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsRefreshNodesResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsRefreshNodes(
    session: GameConnection,
    request: ClubWarsRefreshNodesRequest
) {
    session.sendResponse(ClubWarsRefreshNodesResponse())
}