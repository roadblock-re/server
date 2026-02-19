package moe.crx.roadblock.objects.gacha

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.blackmarket.BlackMarketItem

@Serializable
data class GachaRewardPack(
    var item: BlackMarketItem,
    var amount: UInt,
)