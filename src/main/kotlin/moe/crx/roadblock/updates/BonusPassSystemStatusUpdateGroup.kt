package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.BonusPassId
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.FreeFuelRefillsAmount
import moe.crx.roadblock.objects.FreeTLETicketsRefillsAmount
import moe.crx.roadblock.objects.bonuspass.BonusPassType

@Serializable
sealed class BonusPassSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<BonusPassSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(BonusPassSystemBonusPassStarted::class)
            add(BonusPassSystemBonusPassFinished::class)
            add(BonusPassSystemBonusPassDurationModified::class)
            add(BonusPassSystemBonusPassEventIdModified::class)
            add(BonusPassSystemRemoveEvents::class)
            add(BonusPassSystemBenefitFuelRefillsAmountChanged::class)
            add(BonusPassSystemBenefitFuelRefillsRestored::class)
            add(BonusPassSystemBenefitTLETicketsRefillsAmountChanged::class)
            add(BonusPassSystemBenefitTLETicketsRefillsRestored::class)
            add(BonusPassSystemNextTLETicketsRefillTimeChanged::class)
        }
    }
}

@Serializable
data class BonusPassSystemBonusPassStarted(
    var eventId: CalendarEventId,
    var id: BonusPassId,
    var startDate: Instant,
    var duration: Instant,
    var type: BonusPassType,
) : BonusPassSystemStatusUpdateGroup()

@Serializable
class BonusPassSystemBonusPassFinished(
    var eventId: CalendarEventId,
    var id: BonusPassId,
) : BonusPassSystemStatusUpdateGroup()

@Serializable
data class BonusPassSystemBonusPassDurationModified(
    var eventId: CalendarEventId,
    var previousDuration: Instant,
    var newDuration: Instant,
) : BonusPassSystemStatusUpdateGroup()

@Serializable
data class BonusPassSystemBonusPassEventIdModified(
    var oldEventId: CalendarEventId,
    var newEventId: CalendarEventId,
    var duration: Instant,
) : BonusPassSystemStatusUpdateGroup()

@Serializable
data class BonusPassSystemRemoveEvents(
    var eventIds: List<CalendarEventId>
) : BonusPassSystemStatusUpdateGroup()

@Serializable
class BonusPassSystemBenefitFuelRefillsAmountChanged(
    var oldAmount: FreeFuelRefillsAmount,
    var newAmount: FreeFuelRefillsAmount,
) : BonusPassSystemStatusUpdateGroup()

@Serializable
class BonusPassSystemBenefitFuelRefillsRestored(
    var newRestoreTime: Instant
) : BonusPassSystemStatusUpdateGroup()

@Serializable
data class BonusPassSystemBenefitTLETicketsRefillsAmountChanged(
    var oldAmount: FreeTLETicketsRefillsAmount,
    var newAmount: FreeTLETicketsRefillsAmount,
) : BonusPassSystemStatusUpdateGroup()

@Serializable
data class BonusPassSystemBenefitTLETicketsRefillsRestored(
    var newRestoreTime: Instant
) : BonusPassSystemStatusUpdateGroup()

@Serializable
data class BonusPassSystemNextTLETicketsRefillTimeChanged(
    var newRestoreTime: Instant
) : BonusPassSystemStatusUpdateGroup()