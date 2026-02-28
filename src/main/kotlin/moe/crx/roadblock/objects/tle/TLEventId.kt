package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId

@Serializable
data class TLEventId(
    var eventId: CalendarEventId,
    var specialEventIndex: UInt?,
)