package moe.crx.roadblock.objects.transactions

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ItemID

@Serializable
data class ItemToPurchase(
    var itemId: ItemID,
    var amount: UInt,
)
