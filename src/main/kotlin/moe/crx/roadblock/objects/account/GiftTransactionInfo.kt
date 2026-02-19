package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class GiftTransactionInfo(
    var campaignId: String,
    var pointcutName: String,
    var pointcutParameters: String,
)