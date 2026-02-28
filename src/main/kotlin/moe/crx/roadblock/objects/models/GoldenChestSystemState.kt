package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.goldenchest.GoldenChestEventState

@Serializable
data class GoldenChestSystemState(
    var eventDataById: Map<CalendarEventId, GoldenChestEventState> = mapOf(),
)