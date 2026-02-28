package moe.crx.roadblock.objects.transactions

import kotlinx.serialization.Serializable

@Serializable
data class GiftTransactionInfo(
    var campaignId: String,
    var pointcutName: String,
    var pointcutParameters: String,
)