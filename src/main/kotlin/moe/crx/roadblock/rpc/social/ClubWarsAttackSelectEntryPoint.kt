package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsAttackSelectEntryPointRequest(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsAttackSelectEntryPointResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsAttackSelectEntryPoint(
    session: GameConnection,
    request: ClubWarsAttackSelectEntryPointRequest
) {
    session.sendResponse(ClubWarsAttackSelectEntryPointResponse())
}