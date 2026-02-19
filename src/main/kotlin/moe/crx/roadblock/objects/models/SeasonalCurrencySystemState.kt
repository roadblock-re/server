package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.seasonalcurrency.SeasonalCurrencyEventData

@Serializable
data class SeasonalCurrencySystemState(
    var currentEventData: SeasonalCurrencyEventData? = null,
    var convertedEvents: List<CalendarEventId> = listOf(),
    var conversionRateBoost: Float? = null,
)