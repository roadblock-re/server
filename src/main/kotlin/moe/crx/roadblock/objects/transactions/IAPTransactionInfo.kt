package moe.crx.roadblock.objects.transactions

import kotlinx.serialization.Serializable

@Serializable
data class IAPTransactionInfo(
    var contentId: String = "",
    var currencyCode: String = "",
    var hasBundleItems: Boolean = false,
    var pricePaid: Float = 0f,
    var transactionId: String = "",
    var transactionIdentifier: String = "",
    var transactionCID: Int = 0,
    var transactionSKU: Int = 0,
    var receipt: String = "",
    var receiptSignature: String = "",
    var isRedeem: Boolean = false,
    var isExternalStore: Boolean = false,
)