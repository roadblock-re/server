package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsDefenseOccupyNodeRequest(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsDefenseOccupyNodeResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsDefenseOccupyNode(
    session: GameConnection,
    request: ClubWarsDefenseOccupyNodeRequest
) {
    session.sendResponse(ClubWarsDefenseOccupyNodeResponse())
}