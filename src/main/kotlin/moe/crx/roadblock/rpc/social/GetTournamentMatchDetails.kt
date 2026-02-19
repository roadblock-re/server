package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.TournamentMatchInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class GetTournamentMatchDetailsRequest : RequestPacket()

@Serializable
data class GetTournamentMatchDetailsResponse(
    var tournamentMatchInfo: TournamentMatchInfo,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetTournamentMatchDetails(
    session: GameConnection,
    request: GetTournamentMatchDetailsRequest
) {
    TODO()
}