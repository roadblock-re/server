package moe.crx.roadblock.objects.gacha

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.inventory.CurrencyType

@Serializable
data class PriceComponent(
    var currency: CurrencyType,
    var value: Money,
)