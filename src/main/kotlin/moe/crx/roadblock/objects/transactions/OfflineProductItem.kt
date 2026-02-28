package moe.crx.roadblock.objects.transactions

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.gacha.PriceComponent

@Serializable
sealed class OfflineProductItem {
    companion object : Variant<OfflineProductItem> {
        override fun variants(version: SerializationVersion) = buildList {
            add(PriceComponentItem::class)
            add(IAPPriceDataItem::class)
        }
    }
}

@Serializable
data class PriceComponentItem(var priceComponent: PriceComponent) : OfflineProductItem()

@Serializable
data class IAPPriceDataItem(var iapPriceData: IAPPriceData) : OfflineProductItem()