package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId

@Serializable
data class ClubWarsState(
    var eventDataById: Map<CalendarEventId, ClubWarsEventData> = mapOf(),
    var isLocked: Boolean = true,
)