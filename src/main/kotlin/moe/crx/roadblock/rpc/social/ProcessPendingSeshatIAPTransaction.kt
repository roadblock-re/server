package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.IAPTransactionInfo
import moe.crx.roadblock.objects.account.TransactionInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ProcessPendingSeshatIAPTransactionRequest(
    @UntilVersion("45.0.0")
    var legacyTransactionInfo: IAPTransactionInfo = IAPTransactionInfo(),
    @FromVersion("45.0.0")
    var transactionInfo: IAPTransactionInfo? = null,
    @FromVersion("45.0.0")
    var entitlementQueryResponse: TransactionInfo? = null,
) : RequestPacket()

@Serializable
class ProcessPendingSeshatIAPTransactionResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleProcessPendingSeshatIAPTransaction(
    session: GameConnection,
    request: ProcessPendingSeshatIAPTransactionRequest
) {
    session.sendResponse(ProcessPendingSeshatIAPTransactionResponse())
}