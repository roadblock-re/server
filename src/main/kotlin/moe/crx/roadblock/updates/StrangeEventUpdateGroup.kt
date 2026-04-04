package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.AsphaltProductID
import moe.crx.roadblock.objects.CalendarEventId

@Serializable
sealed class StrangeEventUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<StrangeEventUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(StrangeEventUpdateGroup0::class)
            add(StrangeEventUpdateGroup1::class)
            add(StrangeEventUpdateGroup2::class)
            add(StrangeEventUpdateGroup3::class)
        }
    }
}

@Serializable
data class StrangeEventUpdateGroup0(
    var eventIds: List<CalendarEventId>,
) : StrangeEventUpdateGroup()

@Serializable
data class StrangeEventUpdateGroup1(
    var eventId: CalendarEventId,
) : StrangeEventUpdateGroup()

@Serializable
data class StrangeEventUpdateGroup2(
    var eventId: CalendarEventId,
    var eventExpirationDate: Instant,
) : StrangeEventUpdateGroup()

@Serializable
data class StrangeEventUpdateGroup3(
    var eventId: CalendarEventId,
    var productID: AsphaltProductID,
) : StrangeEventUpdateGroup()