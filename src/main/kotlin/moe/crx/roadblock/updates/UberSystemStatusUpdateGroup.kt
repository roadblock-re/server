package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.BlackMarketSlotId
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.UberExperience
import moe.crx.roadblock.objects.UberHazardLevel
import moe.crx.roadblock.objects.UberLevelId
import moe.crx.roadblock.objects.UberTierId
import moe.crx.roadblock.objects.uber.UberPoolMissionId

@Serializable
sealed class UberSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<UberSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(UberSystemEventParticipated::class)
            add(UberSystemMissionCompleted::class)
            add(UberSystemExperienceChanged::class)
            add(UberSystemHazardLevelChanged::class)
            add(UberSystemTimesPurchasedForSlotChanged::class) // UberSystemtimesPurchasedForSlotChanged
            add(UberSystemRemoveEvents::class)
            add(UberSystemRaceFinished::class)
            add(UberSystemCarDiscovered::class)
            add(UberSystemRaceReward::class)
            add(UberSystemCurrencyBeenConvertedChanged::class)
            add(UberSystemMilestoneAchieved::class)
            add(UberSystemUberExperienceObtainedInMissionsChanged::class)
            add(UberSystemUberCurrencyObtainedInPinnedMissionChanged::class)
        }
    }
}

@Serializable
data class UberSystemCarDiscovered(
    var eventId: CalendarEventId,
    var carId: CarId,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemCurrencyBeenConvertedChanged(
    var eventId: CalendarEventId,
    var hasBeenConverted: Boolean,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemEventParticipated(
    var eventId: CalendarEventId,
    var tierCount: UInt,
    var levelCount: UInt,
    var timePoint: Instant,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemExperienceChanged(
    var eventId: CalendarEventId,
    var oldExperience: UberExperience,
    var newExperience: UberExperience,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemHazardLevelChanged(
    var eventId: CalendarEventId,
    var hazardLevel: UberHazardLevel,
    var lastCleanTime: Instant,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemMilestoneAchieved(
    var eventId: CalendarEventId,
    var milestoneIdx: UInt,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemMissionCompleted(
    var eventId: CalendarEventId,
    var tierId: UberTierId,
    var poolMissionId: UberPoolMissionId,
    var isSkip: Boolean,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemRaceFinished(
    var eventId: CalendarEventId,
    var carId: CarId,
    var position: UByte,
    var hasFinished: Boolean,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemRaceReward(
    var eventId: CalendarEventId,
    var tierId: UberTierId,
    var poolMissionId: UberPoolMissionId,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemRemoveEvents(
    var eventIds: List<CalendarEventId>
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemUberCurrencyObtainedInPinnedMissionChanged(
    var eventId: CalendarEventId,
    var tierId: UberTierId,
    var oldAmount: Money,
    var newAmount: Money,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemUberExperienceObtainedInMissionsChanged(
    var eventId: CalendarEventId,
    var tierId: UberTierId,
    var oldExperience: UberExperience,
    var newExperience: UberExperience,
) : UberSystemStatusUpdateGroup()

@Serializable
data class UberSystemTimesPurchasedForSlotChanged(
    var eventId: CalendarEventId,
    var levelId: UberLevelId,
    var slotId: BlackMarketSlotId,
    var oldTimesPurchased: UInt,
    var newTimesPurchased: UInt,
) : UberSystemStatusUpdateGroup()