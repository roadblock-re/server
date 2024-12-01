package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.blackmarket.*

class BlackMarketStatusUpdateGroup : RVariant(
    BlackMarketLockedStateChanged::class,
    BlackMarketSlotsRefreshed::class,
    BlackMarketSlotRemainingAmountChanged::class,
    BlackMarketDailyRefreshesChanged::class,
    BlackMarketNextDailyRefreshesResetTimeChanged::class,
    BlackMarketNextAutoRefreshTimeChanged::class,
    BlackMarketConsecutiveRefreshesChanged::class,
    BlackMarketCooldownRefreshesChanged::class,
)