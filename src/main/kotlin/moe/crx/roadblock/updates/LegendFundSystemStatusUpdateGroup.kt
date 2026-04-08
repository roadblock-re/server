package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.GarageLevel
import moe.crx.roadblock.objects.LegendFundTierId

@Serializable
sealed class LegendFundSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<LegendFundSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(LegendFundSystemLegendFundOwnedChanged::class)
            add(LegendFundSystemLegendFundMilestoneClaimed::class)
            add(LegendFundSystemLegendFundReset::class)
        }
    }
}

@Serializable
data class LegendFundSystemLegendFundOwnedChanged(
    var currentOwnedTierId: LegendFundTierId
) : LegendFundSystemStatusUpdateGroup()

@Serializable
data class LegendFundSystemLegendFundMilestoneClaimed(
    @UntilVersion("45.0.0") // TODO find exact version
    var level: GarageLevel = 0u,
    @FromVersion("45.0.0") // TODO find exact version
    var levels: List<GarageLevel> = listOf(),
) : LegendFundSystemStatusUpdateGroup()

@Serializable
class LegendFundSystemLegendFundReset : LegendFundSystemStatusUpdateGroup()