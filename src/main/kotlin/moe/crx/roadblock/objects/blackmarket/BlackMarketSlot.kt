package moe.crx.roadblock.objects.blackmarket

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.objects.account.Money

@Serializable
data class BlackMarketSlot(
    var item: BlackMarketItem?,
    var totalAmount: UInt,
    var remainingAmount: UInt,
    var currency: CurrencyType,
    var basePrice: Money,
    var stepAmount: Money,
    var slotType: BlackMarketSlotType,
)