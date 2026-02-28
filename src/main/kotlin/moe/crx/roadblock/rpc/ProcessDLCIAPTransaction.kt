package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.AsphaltProductID
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ProcessDLCIAPTransactionRequest(
    var productId: AsphaltProductID,
) : RequestPacket()

@Serializable
class ProcessDLCIAPTransactionResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleProcessDLCIAPTransaction(
    session: GameConnection,
    request: ProcessDLCIAPTransactionRequest
) {
    session.sendResponse(ProcessDLCIAPTransactionResponse())
}