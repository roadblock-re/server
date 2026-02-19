package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsDefenseVacateNodeRequest(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var carId: CarId?,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsDefenseVacateNodeResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsDefenseVacateNode(
    session: GameConnection,
    request: ClubWarsDefenseVacateNodeRequest
) {
    session.sendResponse(ClubWarsDefenseVacateNodeResponse())
}