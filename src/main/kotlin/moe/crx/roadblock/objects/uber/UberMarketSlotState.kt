package moe.crx.roadblock.objects.uber

import kotlinx.serialization.Serializable

@Serializable
data class UberMarketSlotState(
    var timesPurchased: UInt,
)