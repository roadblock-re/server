package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.upsellpopup.UpsellPopupEvent

@Serializable
data class UpsellPopupSystemState(
    var eventDataById: Map<CalendarEventId, UpsellPopupEvent> = mapOf(),
    var currentEventId: CalendarEventId = "",
)