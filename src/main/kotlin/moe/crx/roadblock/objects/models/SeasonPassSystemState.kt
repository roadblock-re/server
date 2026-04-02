package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.SeasonPassId
import moe.crx.roadblock.objects.seasonpass.SeasonPassPersistentState
import moe.crx.roadblock.objects.seasonpass.SeasonPassState

@Serializable
data class SeasonPassSystemState(
    var currentSeasonPassEvent: CalendarEventId = "",
    var eventDataById: Map<CalendarEventId, SeasonPassState> = mapOf(),
    @UntilVersion("3.7.0")
    var isLocked: Boolean = true,
    var seasonPassHistory: Map<SeasonPassId, SeasonPassPersistentState> = mapOf(),
    @FromVersion("3.7.0")
    var hasPlayedOnboarding: Boolean = false,
)