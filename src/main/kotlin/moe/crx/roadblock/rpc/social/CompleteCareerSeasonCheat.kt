package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.SeasonId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class CompleteCareerSeasonCheatRequest(
    var seasonId: SeasonId,
) : RequestPacket()

@Serializable
class CompleteCareerSeasonCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleCompleteCareerSeasonCheat(
    session: GameConnection,
    request: CompleteCareerSeasonCheatRequest
) {
    session.sendResponse(CompleteCareerSeasonCheatResponse())
}