package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.account.CalendarEventId

@Serializable
sealed class EventData {
    companion object : Variant<EventData> {
        override fun variants(version: SerializationVersion) = buildList {
            add(EventDataReference::class)
            add(EventDataOsiris::class)
        }
    }

    @Serializable
    data class EventDataReference(val eventId: CalendarEventId) : EventData()

    @Serializable
    data class EventDataOsiris(val eventData: OsirisEventData) : EventData()
}