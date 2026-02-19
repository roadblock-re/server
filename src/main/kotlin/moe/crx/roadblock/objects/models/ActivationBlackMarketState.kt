package moe.crx.roadblock.objects.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ActivationMarketDailyRefreshes

@Serializable
data class ActivationBlackMarketState(
    var slots: List<ActivationBlackMarketSlot>,
    var dailyRefreshes: ActivationMarketDailyRefreshes,
    var nextDailyRefreshesResetTime: Instant,
    var nextAutoRefreshTime: Instant,
)