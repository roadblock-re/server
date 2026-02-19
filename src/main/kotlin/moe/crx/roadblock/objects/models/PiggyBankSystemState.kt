package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.piggybank.PiggyBankState

@Serializable
data class PiggyBankSystemState(
    var eventDataById: Map<CalendarEventId, PiggyBankState> = mapOf(),
    var currentEvent: CalendarEventId = "",
)