package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.ClubWarsRoundIndex
import moe.crx.roadblock.objects.clubwars.ClubWarsMatchmakingDebugOption
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsProcessMatchmakingRequest(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var debugOptions: ClubWarsMatchmakingDebugOption,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsProcessMatchmakingResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsProcessMatchmaking(
    session: GameConnection,
    request: ClubWarsProcessMatchmakingRequest
) {
    session.sendResponse(ClubWarsProcessMatchmakingResponse())
}