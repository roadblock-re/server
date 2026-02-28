package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.PlayerElo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletAddChallengePointsCheatRequest(
    var eventId: CalendarEventId,
    var elo: PlayerElo,
) : RequestPacket()

@Serializable
class GauntletAddChallengePointsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletAddChallengePointsCheat(
    session: GameConnection,
    request: GauntletAddChallengePointsCheatRequest
) {
    session.sendResponse(GauntletAddChallengePointsCheatResponse())
}