package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import kotlin.reflect.KClass

@Serializable
sealed class OverclockSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<OverclockSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out OverclockSystemStatusUpdateGroup>> =
            buildList {
                add(OverclockSystemNotifyOverclockExpireEvent::class)
                add(OverclockSystemRemoveEvents::class)
            }
    }
}

@Serializable
data class OverclockSystemNotifyOverclockExpireEvent(
    var eventId: CalendarEventId,
) : OverclockSystemStatusUpdateGroup()

@Serializable
data class OverclockSystemRemoveEvents(
    var eventIds: List<CalendarEventId>,
) : OverclockSystemStatusUpdateGroup()