package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletStartChallengeRequest(
    var eventId: CalendarEventId,
    var opponentId: UInt,
) : RequestPacket()

@Serializable
class GauntletStartChallengeResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletStartChallenge(
    session: GameConnection,
    request: GauntletStartChallengeRequest
) {
    session.sendResponse(GauntletStartChallengeResponse())
}