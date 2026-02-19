package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.ClubWarsRoundIndex
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsClaimRoundRequest(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsClaimRoundResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsClaimRound(
    session: GameConnection,
    request: ClubWarsClaimRoundRequest
) {
    session.sendResponse(ClubWarsClaimRoundResponse())
}