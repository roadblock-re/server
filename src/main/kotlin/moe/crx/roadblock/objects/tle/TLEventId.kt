package moe.crx.roadblock.objects.tle

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId

@Serializable
data class TLEventId(
    var eventId: CalendarEventId,
    @SerialName("optIndex")
    var specialEventIndex: UInt?,
)