package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class IAPPriceData(
    var price: Float,
    var displayPrice: String,
)