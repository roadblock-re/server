package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.uber.UberSpecialEventData

@Serializable
data class UberSystemState(
    var eventDataById: Map<CalendarEventId, UberSpecialEventData> = mapOf(),
)