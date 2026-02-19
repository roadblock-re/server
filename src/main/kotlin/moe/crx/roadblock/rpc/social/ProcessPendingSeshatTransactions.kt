package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.*
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
    var calendarEventId: CalendarEventId?,
    var relayOfferTierId: RelayOfferTierId?,
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