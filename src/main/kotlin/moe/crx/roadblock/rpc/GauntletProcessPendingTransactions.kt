package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class GauntletProcessPendingTransactionsRequest : RequestPacket()

@Serializable
data class GauntletProcessPendingTransactionsResponse(
    var needRestartAsPlayerBanned: Boolean = false,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletProcessPendingTransactions(
    session: GameConnection,
    request: GauntletProcessPendingTransactionsRequest
) {
    session.sendResponse(GauntletProcessPendingTransactionsResponse())
}