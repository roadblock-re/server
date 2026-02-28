package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletLeaveChallengeRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class GauntletLeaveChallengeResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletLeaveChallenge(
    session: GameConnection,
    request: GauntletLeaveChallengeRequest
) {
    session.sendResponse(GauntletLeaveChallengeResponse())
}