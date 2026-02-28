package moe.crx.roadblock.objects.seasonalcurrency

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId

@Serializable
data class SeasonalCurrencyEventData(
    var seasonalCurrencyExpirationDate: Instant,
    var eventId: CalendarEventId,
)