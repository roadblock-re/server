package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.PiggyBankEventId
import moe.crx.roadblock.objects.PiggyBankTierId

@Serializable
sealed class PiggyBankSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<PiggyBankSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(PiggyBankSystemPiggyBankStarted::class)
            add(PiggyBankSystemPiggyBankFinished::class)
            add(PiggyBankSystemRemoveEvents::class)
            add(PiggyBankSystemPiggyBankCurrentProgressChanged::class)
            add(PiggyBankSystemPiggyBankCurrentTierChanged::class)
            add(PiggyBankSystemPiggyBankFilledTimestampChanged::class)
            add(PiggyBankSystemPiggyBankNotifyTierClaimed::class)
            add(PiggyBankSystemPiggyBankTierAttemptsIncreased::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(PiggyBankSystemStatusUpdateGroup8::class)
            }
        }
    }
}

@Serializable
data class PiggyBankSystemPiggyBankStarted(
    var eventId: CalendarEventId,
    var id: PiggyBankEventId,
    var startDate: Instant,
    var initialProgress: Money,
) : PiggyBankSystemStatusUpdateGroup()

@Serializable
data class PiggyBankSystemPiggyBankFinished(
    var eventId: CalendarEventId,
    var id: PiggyBankEventId,
) : PiggyBankSystemStatusUpdateGroup()

@Serializable
data class PiggyBankSystemRemoveEvents(
    var eventIds: List<CalendarEventId>
) : PiggyBankSystemStatusUpdateGroup()

@Serializable
data class PiggyBankSystemPiggyBankCurrentProgressChanged(
    var eventId: CalendarEventId,
    var oldProgress: Money,
    var newProgress: Money,
) : PiggyBankSystemStatusUpdateGroup()

@Serializable
data class PiggyBankSystemPiggyBankCurrentTierChanged(
    var eventId: CalendarEventId,
    var oldTier: PiggyBankTierId,
    var newTier: PiggyBankTierId,
    @FromVersion("45.0.0") // TODO find exact version
    var changedCapping: UInt = 0u,
) : PiggyBankSystemStatusUpdateGroup()

@Serializable
data class PiggyBankSystemPiggyBankFilledTimestampChanged(
    var eventId: CalendarEventId,
    var filledTimestamp: Instant?,
) : PiggyBankSystemStatusUpdateGroup()

@Serializable
data class PiggyBankSystemPiggyBankNotifyTierClaimed(
    var eventId: CalendarEventId,
    var tierId: PiggyBankTierId,
    var isFreeClaim: Boolean,
    var receivedMoney: Money,
) : PiggyBankSystemStatusUpdateGroup()

@Serializable
data class PiggyBankSystemPiggyBankTierAttemptsIncreased(
    var eventId: CalendarEventId,
    var tierId: PiggyBankTierId,
) : PiggyBankSystemStatusUpdateGroup()

@Serializable
data class PiggyBankSystemStatusUpdateGroup8(
    var oldEventId: CalendarEventId,
    var newEventId: CalendarEventId,
) : PiggyBankSystemStatusUpdateGroup()