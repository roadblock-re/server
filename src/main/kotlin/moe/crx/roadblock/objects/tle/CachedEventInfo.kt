package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventHash
import moe.crx.roadblock.objects.account.CalendarEventId

@Serializable
data class CachedEventInfo(
    var eventId: CalendarEventId,
    var eventHash: CalendarEventHash,
)