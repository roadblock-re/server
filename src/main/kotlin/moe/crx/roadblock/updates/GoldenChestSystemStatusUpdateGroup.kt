package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import kotlin.reflect.KClass

@Serializable
sealed class GoldenChestSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<GoldenChestSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out GoldenChestSystemStatusUpdateGroup>> =
            buildList {
                add(GoldenChestSystemLastChestIndexChanged::class)
                add(GoldenChestSystemGoldenChestEventStarted::class)
                add(GoldenChestSystemGoldenChestEventFinished::class)
                add(GoldenChestSystemRemoveEvents::class)
            }
    }
}

@Serializable
data class GoldenChestSystemLastChestIndexChanged(
    var eventId: CalendarEventId,
    var newLastIndex: UInt,
) : GoldenChestSystemStatusUpdateGroup()

@Serializable
data class GoldenChestSystemGoldenChestEventStarted(
    var eventId: CalendarEventId,
    var startDate: Instant,
) : GoldenChestSystemStatusUpdateGroup()

@Serializable
data class GoldenChestSystemGoldenChestEventFinished(
    var eventId: CalendarEventId,
) : GoldenChestSystemStatusUpdateGroup()

@Serializable
data class GoldenChestSystemRemoveEvents(
    var eventIds: List<CalendarEventId>,
) : GoldenChestSystemStatusUpdateGroup()
