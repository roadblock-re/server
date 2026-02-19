package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId

@Serializable
data class OverclockSystemState(
    var expiredEvents: List<CalendarEventId> = listOf(),
)