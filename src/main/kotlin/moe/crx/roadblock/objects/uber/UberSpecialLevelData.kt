package moe.crx.roadblock.objects.uber

import kotlinx.serialization.Serializable

@Serializable
data class UberSpecialLevelData(
    var uberMarketSlots: List<UberMarketSlotState>,
)
