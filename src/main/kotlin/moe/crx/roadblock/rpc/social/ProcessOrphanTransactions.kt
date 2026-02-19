package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ProcessOrphanTransactionsRequest : RequestPacket()

@Serializable
class ProcessOrphanTransactionsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleProcessOrphanTransactions(
    session: GameConnection,
    request: ProcessOrphanTransactionsRequest
) {
    session.sendResponse(ProcessOrphanTransactionsResponse())
}