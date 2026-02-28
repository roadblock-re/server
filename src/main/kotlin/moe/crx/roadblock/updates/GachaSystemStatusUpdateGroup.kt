package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.gacha.GachaId

@Serializable
sealed class GachaSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<GachaSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(GachaSystemLockedStateChanged::class)
            add(GachaSystemNextBoxIsCriticalChanged::class)
            add(GachaSystemRetentionBoxReadyTimeChanged::class)
            add(GachaSystemOpenedEventBoxes::class)
            add(GachaSystemRemoveEvents::class)
            add(GachaSystemOpenedBoxes::class)
            add(OpenedGachaBoxContainer::class)
        }

    }
}

@Serializable
data class GachaSystemLockedStateChanged(
    var oldLockedState: Boolean,
    var newLockedState: Boolean,
) : GachaSystemStatusUpdateGroup()

@Serializable
data class GachaSystemNextBoxIsCriticalChanged(
    var nextBoxIsCritical: Boolean
) : GachaSystemStatusUpdateGroup()

@Serializable
data class GachaSystemOpenedBoxes(
    var gachaId: GachaId
) : GachaSystemStatusUpdateGroup()

@Serializable
data class GachaSystemOpenedEventBoxes(
    var eventId: CalendarEventId,
    var gachaId: GachaId,
    var oldOpenedCount: UInt,
    var newOpenedCount: UInt,
    var hasFeaturedReward: Boolean,
) : GachaSystemStatusUpdateGroup()

@Serializable
data class GachaSystemRemoveEvents(
    var eventIds: List<CalendarEventId>
) : GachaSystemStatusUpdateGroup()

@Serializable
data class GachaSystemRetentionBoxReadyTimeChanged(
    var oldTimePoint: Instant,
    var newTimePoint: Instant,
) : GachaSystemStatusUpdateGroup()

@Serializable
data class OpenedGachaBoxContainer(
    var gachaId: GachaId,
    var amountOfBoxesOpened: UInt,
) : GachaSystemStatusUpdateGroup()