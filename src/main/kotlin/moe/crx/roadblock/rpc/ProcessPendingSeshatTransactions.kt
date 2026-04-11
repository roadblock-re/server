package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.RelayOfferTierId
import moe.crx.roadblock.objects.transactions.DynamicGiftTransactionInfo
import moe.crx.roadblock.objects.transactions.EntitlementQueryResponse
import moe.crx.roadblock.objects.transactions.IAPTransactionInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ProcessPendingSeshatTransactionsRequest(
    var processEcommerceTransactions: Boolean,
    var processAdsTransactions: Boolean,
    var processDynamicGiftTransactions: Boolean,
    var processGenericTransactions: Boolean,
    var carIdForRefill: CarId?,
    var iapTransactionInfo: IAPTransactionInfo?,
    var dynamicGiftTransactionInfo: DynamicGiftTransactionInfo?,
    @FromVersion("3.9.0")
    var calendarEventId: CalendarEventId? = null,
    @FromVersion("3.9.0")
    var relayOfferTierId: RelayOfferTierId? = null,
    @FromVersion("24.0.0")
    var entitlementQueryResponse: EntitlementQueryResponse? = null,
) : RequestPacket()

@Serializable
class ProcessPendingSeshatTransactionsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleProcessPendingSeshatTransactions(
    session: GameConnection,
    request: ProcessPendingSeshatTransactionsRequest
) {
    session.sendResponse(ProcessPendingSeshatTransactionsResponse())
}