package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.MultiplayerChallengesStageId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesClaimRewardRequest(
    var eventId: CalendarEventId,
    var stageId: MultiplayerChallengesStageId,
) : RequestPacket()

@Serializable
class MultiplayerChallengesClaimRewardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesClaimReward(
    session: GameConnection,
    request: MultiplayerChallengesClaimRewardRequest
) {
    session.sendResponse(MultiplayerChallengesClaimRewardResponse())
}