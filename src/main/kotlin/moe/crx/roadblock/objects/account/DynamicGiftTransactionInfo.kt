package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class DynamicGiftTransactionInfo(
    var templateId: String,
    var sourceCredential: String,
)