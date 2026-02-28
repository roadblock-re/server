package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.InboxMessageId
import moe.crx.roadblock.objects.miscellaneous.InboxProviderType

@Serializable
sealed class InboxStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<InboxStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(InboxMessageRead::class)
            add(InboxRemoveEvents::class)
        }
    }
}

@Serializable
data class InboxMessageRead(
    var messageId: InboxMessageId,
    var providerType: InboxProviderType,
) : InboxStatusUpdateGroup()

@Serializable
data class InboxRemoveEvents(
    var eventIds: List<CalendarEventId>
) : InboxStatusUpdateGroup()