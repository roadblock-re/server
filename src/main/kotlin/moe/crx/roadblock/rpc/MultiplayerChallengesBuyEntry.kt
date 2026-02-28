package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.MultiplayerChallengesStageId
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallengeFee
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesBuyEntryRequest(
    var eventId: CalendarEventId,
    var entryPointId: MultiplayerChallengesStageId,
    var entryFee: MultiplayerChallengeFee,
    var isFreeWithSeasonPass: Boolean,
) : RequestPacket()

@Serializable
class MultiplayerChallengesBuyEntryResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesBuyEntry(
    session: GameConnection,
    request: MultiplayerChallengesBuyEntryRequest
) {
    session.sendResponse(MultiplayerChallengesBuyEntryResponse())
}