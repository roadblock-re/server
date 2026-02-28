package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId

@Serializable
data class TournamentSystemState(
    var highestPlacement: Short = 0,
    var eventDataById: Map<CalendarEventId, TournamentEventState> = mapOf(),
)