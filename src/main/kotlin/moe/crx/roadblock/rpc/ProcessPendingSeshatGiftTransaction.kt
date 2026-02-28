package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.transactions.DynamicGiftTransactionInfo
import moe.crx.roadblock.objects.transactions.GiftTransactionInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ProcessPendingSeshatGiftTransactionRequest(
    @UntilVersion("47.1.0")
    var pointcutId: String = "",
    @UntilVersion("47.1.0")
    var pointcutArguments: String = "",
    @UntilVersion("47.1.0")
    var campaignId: String = "",
    @FromVersion("47.1.0")
    var mercuryGiftTransactionInfo: GiftTransactionInfo? = null,
    @FromVersion("47.1.0")
    var dynamicGiftTransactionInfo: DynamicGiftTransactionInfo? = null,
) : RequestPacket()

@Serializable
class ProcessPendingSeshatGiftTransactionResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleProcessPendingSeshatGiftTransaction(
    session: GameConnection,
    request: ProcessPendingSeshatGiftTransactionRequest
) {
    session.sendResponse(ProcessPendingSeshatGiftTransactionResponse())
}