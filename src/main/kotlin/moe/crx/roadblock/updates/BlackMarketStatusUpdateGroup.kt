package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.BlackMarketDailyRefreshes
import moe.crx.roadblock.objects.BlackMarketSlotId
import moe.crx.roadblock.objects.blackmarket.BlackMarketItem
import moe.crx.roadblock.objects.blackmarket.BlackMarketSlot

@Serializable
sealed class BlackMarketStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<BlackMarketStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(BlackMarketLockedStateChanged::class)
            add(BlackMarketSlotsRefreshed::class)
            add(BlackMarketSlotRemainingAmountChanged::class)
            add(BlackMarketDailyRefreshesChanged::class)
            add(BlackMarketNextDailyRefreshesResetTimeChanged::class)
            add(BlackMarketNextAutoRefreshTimeChanged::class)
            add(BlackMarketConsecutiveRefreshesChanged::class)
            add(BlackMarketCooldownRefreshesChanged::class)
        }
    }
}

@Serializable
data class BlackMarketConsecutiveRefreshesChanged(
    var item: BlackMarketItem,
    var oldRefreshes: BlackMarketDailyRefreshes,
    var newRefreshes: BlackMarketDailyRefreshes,
) : BlackMarketStatusUpdateGroup()

@Serializable
data class BlackMarketCooldownRefreshesChanged(
    var item: BlackMarketItem,
    var oldRefreshes: BlackMarketDailyRefreshes,
    var newRefreshes: BlackMarketDailyRefreshes,
) : BlackMarketStatusUpdateGroup()

@Serializable
data class BlackMarketDailyRefreshesChanged(
    var oldRefreshes: BlackMarketDailyRefreshes,
    var newRefreshes: BlackMarketDailyRefreshes,
) : BlackMarketStatusUpdateGroup()

@Serializable
data class BlackMarketLockedStateChanged(
    var oldLockedState: Boolean,
    var newLockedState: Boolean,
) : BlackMarketStatusUpdateGroup()

@Serializable
data class BlackMarketNextAutoRefreshTimeChanged(
    var oldTimePoint: Instant,
    var newTimePoint: Instant,
) : BlackMarketStatusUpdateGroup()

@Serializable
data class BlackMarketNextDailyRefreshesResetTimeChanged(
    var oldTimePoint: Instant,
    var newTimePoint: Instant,
) : BlackMarketStatusUpdateGroup()

@Serializable
data class BlackMarketSlotRemainingAmountChanged(
    var slot: BlackMarketSlotId,
    var oldAmount: UInt,
    var newAmount: UInt,
) : BlackMarketStatusUpdateGroup()

@Serializable
data class BlackMarketSlotsRefreshed(
    var slots: List<BlackMarketSlot>
) : BlackMarketStatusUpdateGroup()