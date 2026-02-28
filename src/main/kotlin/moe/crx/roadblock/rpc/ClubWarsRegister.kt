package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ClubWarsRoundIndex
import moe.crx.roadblock.objects.clubwars.ClubWarsRegisterDebugOption
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsRegisterRequest(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var debugOptions: ClubWarsRegisterDebugOption,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsRegisterResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsRegister(
    session: GameConnection,
    request: ClubWarsRegisterRequest
) {
    session.sendResponse(ClubWarsRegisterResponse())
}