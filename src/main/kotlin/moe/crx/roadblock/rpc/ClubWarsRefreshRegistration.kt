package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ClubWarsRoundIndex
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsRefreshRegistrationRequest(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsRefreshRegistrationResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsRefreshRegistration(
    session: GameConnection,
    request: ClubWarsRefreshRegistrationRequest
) {
    session.sendResponse(ClubWarsRefreshRegistrationResponse())
}