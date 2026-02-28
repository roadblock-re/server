package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.SeasonPassId
import moe.crx.roadblock.objects.seasonpass.SeasonPassPersistentState
import moe.crx.roadblock.objects.seasonpass.SeasonPassState

@Serializable
data class SeasonPassSystemState(
    var currentSeasonPassEvent: CalendarEventId = "",
    var eventDataById: Map<CalendarEventId, SeasonPassState> = mapOf(),
    var seasonPassHistory: Map<SeasonPassId, SeasonPassPersistentState> = mapOf(),
    var hasPlayedOnboarding: Boolean = false,
)