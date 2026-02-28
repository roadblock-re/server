package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsDefenseUnassignCarRequest(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsDefenseUnassignCarResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsDefenseUnassignCar(
    session: GameConnection,
    request: ClubWarsDefenseUnassignCarRequest
) {
    session.sendResponse(ClubWarsDefenseUnassignCarResponse())
}