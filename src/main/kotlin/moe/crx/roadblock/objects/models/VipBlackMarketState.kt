package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.DateTimeUnit.Companion.HOUR
import kotlinx.datetime.Instant
import kotlinx.datetime.plus
import kotlinx.serialization.Serializable
import moe.crx.roadblock.core.utils.midnight
import moe.crx.roadblock.objects.account.BlackMarketDailyRefreshes

@Serializable
data class VipBlackMarketState(
    var slots: List<VipBlackMarketSlot> = listOf(),
    var dailyRefreshes: BlackMarketDailyRefreshes = 0u,
    var nextDailyResetTime: Instant = now().midnight().plus(24, HOUR),
    var nextAutoRefreshTime: Instant = now().midnight().plus(24, HOUR),
)