package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.GarageLevel

@Serializable
data class LegendFundSystemState(
    @FromVersion("24.0.0")
    var ownedTierCount: UShort = 0u,
    @UntilVersion("24.0.0")
    var legacyOwnedTierCount: UByte = 0u,
    var claimedMilestones: List<GarageLevel> = listOf(),
)