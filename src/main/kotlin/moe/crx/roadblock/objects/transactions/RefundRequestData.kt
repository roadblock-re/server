package moe.crx.roadblock.objects.transactions

import kotlinx.serialization.Serializable

@Serializable
data class RefundRequestData(
    var msgId: String,
    var transactionId: String,
    var price: String,
)