package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class StatusUpdatesQueueWithRootReactions(
    var statusUpdates: List<StatusUpdate> = listOf(),
    var rootReactions: List<UInt> = listOf(),
)