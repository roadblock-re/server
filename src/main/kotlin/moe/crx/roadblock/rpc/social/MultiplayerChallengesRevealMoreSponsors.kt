package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.MultiplayerChallengesStageId
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallengeFee
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesRevealMoreSponsorsRequest(
    var eventId: CalendarEventId,
    var revealedSponsorsStep: MultiplayerChallengesStageId,
    var price: MultiplayerChallengeFee,
) : RequestPacket()

@Serializable
class MultiplayerChallengesRevealMoreSponsorsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesRevealMoreSponsors(
    session: GameConnection,
    request: MultiplayerChallengesRevealMoreSponsorsRequest
) {
    session.sendResponse(MultiplayerChallengesRevealMoreSponsorsResponse())
}