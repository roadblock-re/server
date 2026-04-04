package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import kotlin.reflect.KClass

@Serializable
sealed class SeasonalCurrencySystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<SeasonalCurrencySystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out SeasonalCurrencySystemStatusUpdateGroup>> =
            buildList {
                add(SeasonalCurrencySystemNotifySeasonalCurrencyConversion::class)
                add(SeasonalCurrencySystemRemoveEvents::class)
                add(SeasonalCurrencySystemNotifyConversionRateBoostChanged::class)
            }
    }
}

@Serializable
data class SeasonalCurrencySystemNotifySeasonalCurrencyConversion(
    var eventId: CalendarEventId,
) : SeasonalCurrencySystemStatusUpdateGroup()

@Serializable
data class SeasonalCurrencySystemRemoveEvents(
    var eventIds: List<CalendarEventId>,
) : SeasonalCurrencySystemStatusUpdateGroup()

@Serializable
data class SeasonalCurrencySystemNotifyConversionRateBoostChanged(
    var optConversionRateBoost: Float?,
) : SeasonalCurrencySystemStatusUpdateGroup()