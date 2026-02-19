package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UpdateTournamentMatchStatusRequest(
    var status: UInt,
) : RequestPacket()

@Serializable
class UpdateTournamentMatchStatusResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUpdateTournamentMatchStatus(
    session: GameConnection,
    request: UpdateTournamentMatchStatusRequest
) {
    session.sendResponse(UpdateTournamentMatchStatusResponse())
}