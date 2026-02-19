package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.gauntlet.GauntletEventState
import moe.crx.roadblock.objects.gauntlet.GauntletMarketState

@Serializable
data class GauntletSystemState(
    var eventDataById: Map<CalendarEventId, GauntletEventState> = mapOf(),
    var currentEventId: CalendarEventId = "",
    var market: GauntletMarketState = GauntletMarketState(),
)