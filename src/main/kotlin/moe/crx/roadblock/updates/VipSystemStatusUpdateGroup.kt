package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId

@Serializable
sealed class VipSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<VipSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(VipSystemStatusUpdateGroup0::class)
        }
    }
}

@Serializable
data class VipSystemStatusUpdateGroup0(
    var eventIds: List<CalendarEventId>,
) : VipSystemStatusUpdateGroup()