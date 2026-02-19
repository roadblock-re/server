package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.TournamentMatchInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class JoinTournamentMatchRequest(
    var playstationMatchId: String,
) : RequestPacket()

@Serializable
data class JoinTournamentMatchResponse(
    var tournamentMatchInfo: TournamentMatchInfo,
    var isUserOwner: Boolean = false,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleJoinTournamentMatch(
    session: GameConnection,
    request: JoinTournamentMatchRequest
) {
    TODO()
}