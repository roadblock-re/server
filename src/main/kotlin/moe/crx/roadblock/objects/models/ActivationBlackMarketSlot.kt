package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.blackmarket.BlackMarketItem
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.objects.Money

@Serializable
data class ActivationBlackMarketSlot(
    var item: BlackMarketItem,
    var totalAmount: UInt,
    var remainingAmount: UInt,
    var maxPurchases: UInt,
    var currency: CurrencyType,
    var basePrice: Money,
    var stepAmount: Money,
)