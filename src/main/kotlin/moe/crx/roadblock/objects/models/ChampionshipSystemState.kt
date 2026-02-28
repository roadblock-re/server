package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.championship.ChampionshipSpecialEventData
import moe.crx.roadblock.objects.CalendarEventId

@Serializable
data class ChampionshipSystemState(
    var eventDataById: Map<CalendarEventId, ChampionshipSpecialEventData> = mapOf(),
)