package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class RefundRequestData(
    var msgId: String,
    var transactionId: String,
    var price: String,
)