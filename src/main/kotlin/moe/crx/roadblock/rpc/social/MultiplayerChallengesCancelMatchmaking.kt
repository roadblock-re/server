package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.MultiplayerChallengesSeriesId
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesCancelMatchmakingRequest(
    var seriesId: MultiplayerChallengesSeriesId,
    var eventId: CalendarEventId,
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
) : RequestPacket()

@Serializable
class MultiplayerChallengesCancelMatchmakingResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesCancelMatchmaking(
    session: GameConnection,
    request: MultiplayerChallengesCancelMatchmakingRequest
) {
    session.sendResponse(MultiplayerChallengesCancelMatchmakingResponse())
}