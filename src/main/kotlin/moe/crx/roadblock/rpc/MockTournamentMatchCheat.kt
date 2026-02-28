package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MockTournamentMatchCheatRequest(
    var property: String,
) : RequestPacket()

@Serializable
data class MockTournamentMatchCheatResponse(
    var playstationMatchId: String = "",
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMockTournamentMatchCheat(
    session: GameConnection,
    request: MockTournamentMatchCheatRequest
) {
    session.sendResponse(MockTournamentMatchCheatResponse())
}