package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.blackmarket.BlackMarketItem

@Serializable
data class UserCustomizableBundleReward(
    var item: BlackMarketItem,
    var amount: UInt,
)