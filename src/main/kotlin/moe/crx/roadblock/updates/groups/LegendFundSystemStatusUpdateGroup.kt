package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.legendfund.LegendFundSystemLegendFundMilestoneClaimed
import moe.crx.roadblock.updates.legendfund.LegendFundSystemLegendFundOwnedChanged
import moe.crx.roadblock.updates.legendfund.LegendFundSystemLegendFundReset

class LegendFundSystemStatusUpdateGroup : RVariant(
    LegendFundSystemLegendFundOwnedChanged::class,
    LegendFundSystemLegendFundMilestoneClaimed::class,
    LegendFundSystemLegendFundReset::class,
)