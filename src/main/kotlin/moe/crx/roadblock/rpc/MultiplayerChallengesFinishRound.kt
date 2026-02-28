package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesFinishRoundRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class MultiplayerChallengesFinishRoundResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesFinishRound(
    session: GameConnection,
    request: MultiplayerChallengesFinishRoundRequest
) {
    session.sendResponse(MultiplayerChallengesFinishRoundResponse())
}