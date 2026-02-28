package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.TLETicket
import moe.crx.roadblock.objects.tle.TLEventData
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.objects.tle.TimeLimitedSpecialData

@Serializable
data class TLEventsSystemState(
    var ticketBalance: TLETicket = 10u,
    var lastTicketRefilledTime: Instant = now(),
    var eventDataById: Map<TLEventId, TLEventData> = mapOf(),
    var specialEventDataById: Map<CalendarEventId, TimeLimitedSpecialData> = mapOf(),
    var isLocked: Boolean = true,
)