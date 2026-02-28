package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.InboxMessageId
import moe.crx.roadblock.objects.miscellaneous.InboxProviderType

@Serializable
data class InboxState(
    var readMessages: Map<InboxProviderType, List<InboxMessageId>> = mapOf(),
)