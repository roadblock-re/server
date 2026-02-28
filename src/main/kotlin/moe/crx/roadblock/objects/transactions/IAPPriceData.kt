package moe.crx.roadblock.objects.transactions

import kotlinx.serialization.Serializable

@Serializable
data class IAPPriceData(
    var price: Float,
    var displayPrice: String,
)