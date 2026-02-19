package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.DateTimeUnit.Companion.HOUR
import kotlinx.datetime.Instant
import kotlinx.datetime.plus
import kotlinx.serialization.Serializable
import moe.crx.roadblock.core.utils.midnight
import moe.crx.roadblock.objects.account.GauntletDivision
import moe.crx.roadblock.objects.account.GauntletLeague
import moe.crx.roadblock.objects.account.GauntletMarketProductId

@Serializable
data class GauntletMarketState(
    var productsBought: List<GauntletMarketProductId> = listOf(),
    var timesProductBoughtInCurrentRefresh: Map<GauntletMarketProductId, UInt> = mapOf(),
    var nextAutoRefreshTime: Instant = now().midnight().plus(24, HOUR),
    var lastPlayedGauntletDivision: GauntletDivision = 0u,
    var isLocked: Boolean = true,
    var lastPlayedGauntletLeague: GauntletLeague = 0u,
)