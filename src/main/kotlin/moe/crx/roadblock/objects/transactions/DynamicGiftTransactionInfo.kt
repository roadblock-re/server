package moe.crx.roadblock.objects.transactions

import kotlinx.serialization.Serializable

@Serializable
data class DynamicGiftTransactionInfo(
    var templateId: String,
    var sourceCredential: String,
)