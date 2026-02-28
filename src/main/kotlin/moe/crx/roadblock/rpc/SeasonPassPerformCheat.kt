package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SeasonPassPerformCheatRequest(
    var hasPlayed: Boolean,
) : RequestPacket()

@Serializable
class SeasonPassPerformCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSeasonPassPerformCheat(
    session: GameConnection,
    request: SeasonPassPerformCheatRequest
) {
    session.sendResponse(SeasonPassPerformCheatResponse())
}