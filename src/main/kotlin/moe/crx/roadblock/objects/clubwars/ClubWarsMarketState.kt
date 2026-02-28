package moe.crx.roadblock.objects.clubwars

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubWarsMarketProductId

@Serializable
data class ClubWarsMarketState(
    var isLocked: Boolean = true,
    var productsBought: List<ClubWarsMarketProductId> = listOf(),
    var timesProductBoughtInCurrentRefresh: Map<ClubWarsMarketProductId, UInt> = mapOf(),
    var nextAutoRefreshTime: Instant = now(),
)