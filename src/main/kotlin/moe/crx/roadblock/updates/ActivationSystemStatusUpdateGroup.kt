package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.BlackMarketDailyRefreshes
import moe.crx.roadblock.objects.BlackMarketSlotId
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.objects.models.ActivationBlackMarketSlot

@Serializable
sealed class ActivationSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<ActivationSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(ActivationSystemStatusUpdateGroup0::class)
            add(ActivationSystemStatusUpdateGroup1::class)
            add(ActivationSystemStatusUpdateGroup2::class)
            add(ActivationSystemStatusUpdateGroup3::class)
            add(ActivationSystemStatusUpdateGroup4::class)
            add(ActivationSystemStatusUpdateGroup5::class)
            add(ActivationSystemStatusUpdateGroup6::class)
            add(ActivationSystemStatusUpdateGroup7::class)
            add(ActivationSystemStatusUpdateGroup8::class)
            add(ActivationSystemStatusUpdateGroup9::class)
        }
    }
}

@Serializable
data class ActivationSystemStatusUpdateGroup0(
    var eventId: CalendarEventId,
) : ActivationSystemStatusUpdateGroup()

@Serializable
data class ActivationSystemStatusUpdateGroup1(
    var eventIds: List<CalendarEventId>,
) : ActivationSystemStatusUpdateGroup()

@Serializable
data class ActivationSystemStatusUpdateGroup2(
    var eventId: CalendarEventId,
    var currency: CurrencyType,
    var activationExpirationDate: Instant,
) : ActivationSystemStatusUpdateGroup()

@Serializable
data class ActivationSystemStatusUpdateGroup3(
    var eventId: CalendarEventId,
) : ActivationSystemStatusUpdateGroup()

@Serializable
data class ActivationSystemStatusUpdateGroup4(
    var eventId: CalendarEventId,
    var slots: List<ActivationBlackMarketSlot>,
) : ActivationSystemStatusUpdateGroup()

@Serializable
data class ActivationSystemStatusUpdateGroup5(
    var eventId: CalendarEventId,
    var slot: BlackMarketSlotId,
    var oldAmount: UInt,
    var newAmount: UInt,
) : ActivationSystemStatusUpdateGroup()

@Serializable
data class ActivationSystemStatusUpdateGroup6(
    var eventId: CalendarEventId,
    var oldRefreshes: BlackMarketDailyRefreshes,
    var newRefreshes: BlackMarketDailyRefreshes,
) : ActivationSystemStatusUpdateGroup()

@Serializable
data class ActivationSystemStatusUpdateGroup7(
    var eventId: CalendarEventId,
    var oldTimePoint: Instant,
    var newTimePoint: Instant,
) : ActivationSystemStatusUpdateGroup()

@Serializable
data class ActivationSystemStatusUpdateGroup8(
    var eventId: CalendarEventId,
    var oldTimePoint: Instant,
    var newTimePoint: Instant,
) : ActivationSystemStatusUpdateGroup()

@Serializable
data class ActivationSystemStatusUpdateGroup9(
    var linkedEventId: CalendarEventId,
    var activationEventId: CalendarEventId,
) : ActivationSystemStatusUpdateGroup()
