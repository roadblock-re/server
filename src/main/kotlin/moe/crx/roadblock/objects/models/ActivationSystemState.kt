package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId

@Serializable
data class ActivationSystemState(
    var eventDataById: Map<CalendarEventId, ActivationEventData> = mapOf(),
    var convertedEvents: List<CalendarEventId> = listOf(),
)