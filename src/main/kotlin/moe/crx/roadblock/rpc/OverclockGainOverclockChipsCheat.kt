package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.OverclockChips
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class OverclockGainOverclockChipsCheatRequest(
    var canExceedCap: Boolean,
    var amount: OverclockChips,
) : RequestPacket()

@Serializable
class OverclockGainOverclockChipsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleOverclockGainOverclockChipsCheat(
    session: GameConnection,
    request: OverclockGainOverclockChipsCheatRequest
) {
    session.sendResponse(OverclockGainOverclockChipsCheatResponse())
}