package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.UpsellPopupOfferIndex
import kotlin.reflect.KClass

@Serializable
sealed class UpsellPopupSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<UpsellPopupSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out UpsellPopupSystemStatusUpdateGroup>> =
            buildList {
                add(UpsellPopupSystemUpsellPopupEventStarted::class)
                add(UpsellPopupSystemUpsellPopupEventFinished::class)
                add(UpsellPopupSystemRemoveEvents::class)
                add(UpsellPopupPurchaseOfferUpdate::class)
            }
    }
}

@Serializable
data class UpsellPopupSystemUpsellPopupEventStarted(
    var eventId: CalendarEventId,
    var startDate: Instant,
) : UpsellPopupSystemStatusUpdateGroup()

@Serializable
data class UpsellPopupSystemUpsellPopupEventFinished(
    var eventId: CalendarEventId,
) : UpsellPopupSystemStatusUpdateGroup()

@Serializable
data class UpsellPopupSystemRemoveEvents(
    var events: List<CalendarEventId>,
) : UpsellPopupSystemStatusUpdateGroup()

@Serializable
data class UpsellPopupPurchaseOfferUpdate(
    var eventId: CalendarEventId,
    var offerIndex: UpsellPopupOfferIndex,
    var fromIAP: Boolean,
) : UpsellPopupSystemStatusUpdateGroup()