package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class ItemToPurchase(
    var itemId: ItemID,
    var amount: UInt,
)