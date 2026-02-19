package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallengeFee
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesReviveRoundRequest(
    var eventId: CalendarEventId,
    var fee: MultiplayerChallengeFee,
) : RequestPacket()

@Serializable
class MultiplayerChallengesReviveRoundResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesReviveRound(
    session: GameConnection,
    request: MultiplayerChallengesReviveRoundRequest
) {
    session.sendResponse(MultiplayerChallengesReviveRoundResponse())
}