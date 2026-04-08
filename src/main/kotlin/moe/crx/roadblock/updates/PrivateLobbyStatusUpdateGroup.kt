package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId

@Serializable
sealed class PrivateLobbyStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<PrivateLobbyStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(PrivateLobbyRemoveEvents::class)
            add(PrivateLobbyRaceFinished::class)
        }
    }
}

@Serializable
data class PrivateLobbyRemoveEvents(
    var eventIds: List<CalendarEventId>
) : PrivateLobbyStatusUpdateGroup()

@Serializable
data class PrivateLobbyRaceFinished(
    var eventId: CalendarEventId,
    var position: UByte,
    var laps: UInt,
    var hasFinished: Boolean,
) : PrivateLobbyStatusUpdateGroup()