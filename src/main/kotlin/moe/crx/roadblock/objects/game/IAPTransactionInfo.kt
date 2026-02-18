package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class IAPTransactionInfo : RObject {

    var contentId: String = ""
    var currencyCode: String = ""
    var hasBundleItems: Boolean = false
    var pricePaid: Float = 0.0f
    var transactionId: String = ""
    var transactionIdentifier: String = ""
    var transactionCID: Int = 0
    var transactionSKU: Int = 0
    var receipt: String = ""
    var receiptSignature: String = ""
    var isRedeem: Boolean = false
    var isExternalStore: Boolean = false

    override fun read(sink: InputSink) {
        contentId = sink.readString()
        currencyCode = sink.readString()
        hasBundleItems = sink.readBoolean()
        pricePaid = sink.readFloat()
        transactionId = sink.readString()
        transactionIdentifier = sink.readString()
        transactionCID = sink.readInt()
        transactionSKU = sink.readInt()
        receipt = sink.readString()
        receiptSignature = sink.readString()
        isRedeem = sink.readBoolean()
        isExternalStore = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(contentId)
        sink.writeString(currencyCode)
        sink.writeBoolean(hasBundleItems)
        sink.writeFloat(pricePaid)
        sink.writeString(transactionId)
        sink.writeString(transactionIdentifier)
        sink.writeInt(transactionCID)
        sink.writeInt(transactionSKU)
        sink.writeString(receipt)
        sink.writeString(receiptSignature)
        sink.writeBoolean(isRedeem)
        sink.writeBoolean(isExternalStore)
    }
}