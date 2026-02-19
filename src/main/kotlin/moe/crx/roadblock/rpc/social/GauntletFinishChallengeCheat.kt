package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletFinishChallengeCheatRequest(
    var eventId: CalendarEventId,
    var win: Boolean,
) : RequestPacket()

@Serializable
class GauntletFinishChallengeCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletFinishChallengeCheat(
    session: GameConnection,
    request: GauntletFinishChallengeCheatRequest
) {
    session.sendResponse(GauntletFinishChallengeCheatResponse())
}