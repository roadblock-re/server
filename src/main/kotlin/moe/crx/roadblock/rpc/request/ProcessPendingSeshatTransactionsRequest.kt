package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.DynamicGiftTransactionInfo
import moe.crx.roadblock.objects.game.EntitlementQueryResponse
import moe.crx.roadblock.objects.game.IAPTransactionInfo
import moe.crx.roadblock.rpc.base.RequestPacket

class ProcessPendingSeshatTransactionsRequest : RequestPacket() {

    var processEcommerceTransactions: Boolean = false
    var processAdsTransactions: Boolean = false
    var processDynamicGiftTransactions: Boolean = false
    var processGenericTransactions: Boolean = false
    var carIdForRefill: RInt? = null // CarId
    var iapTransactionInfo: IAPTransactionInfo? = null
    var dynamicGiftTransactionInfo: DynamicGiftTransactionInfo? = null
    var calendarEventId: RString? = null // CalendarEventId
    var relayOfferTierId: RInt? = null // RelayOfferTierId
    var entitlementQueryResponse: EntitlementQueryResponse? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        processEcommerceTransactions = sink.readBoolean()
        processAdsTransactions = sink.readBoolean()
        processDynamicGiftTransactions = sink.readBoolean()
        processGenericTransactions = sink.readBoolean()
        carIdForRefill = sink.readOptional()
        iapTransactionInfo = sink.readOptional()
        dynamicGiftTransactionInfo = sink.readOptional()
        calendarEventId = sink.readOptional()
        relayOfferTierId = sink.readOptional()
        if (sink newer "24.0.0") {
            entitlementQueryResponse = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeBoolean(processEcommerceTransactions)
        sink.writeBoolean(processAdsTransactions)
        sink.writeBoolean(processDynamicGiftTransactions)
        sink.writeBoolean(processGenericTransactions)
        sink.writeOptional(carIdForRefill)
        sink.writeOptional(iapTransactionInfo)
        sink.writeOptional(dynamicGiftTransactionInfo)
        sink.writeOptional(calendarEventId)
        sink.writeOptional(relayOfferTierId)
        if (sink newer "24.0.0") {
            sink.writeOptional(entitlementQueryResponse)
        }
    }
}