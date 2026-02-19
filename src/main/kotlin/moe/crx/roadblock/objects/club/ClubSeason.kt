package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId

@Serializable
data class ClubSeason(
    var currentEventId: CalendarEventId = "",
    var eventDataById: Map<CalendarEventId, ClubSeasonEvent> = mapOf(),
)