package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class QuitTournamentMatchRequest : RequestPacket()

@Serializable
class QuitTournamentMatchResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleQuitTournamentMatch(
    session: GameConnection,
    request: QuitTournamentMatchRequest
) {
    session.sendResponse(QuitTournamentMatchResponse())
}