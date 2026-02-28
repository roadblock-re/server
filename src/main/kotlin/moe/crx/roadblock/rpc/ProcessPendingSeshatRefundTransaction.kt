package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.transactions.RefundRequestData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ProcessPendingSeshatRefundTransactionRequest(
    var refundRequests: List<RefundRequestData>,
) : RequestPacket()

@Serializable
class ProcessPendingSeshatRefundTransactionResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleProcessPendingSeshatRefundTransaction(
    session: GameConnection,
    request: ProcessPendingSeshatRefundTransactionRequest
) {
    session.sendResponse(ProcessPendingSeshatRefundTransactionResponse())
}