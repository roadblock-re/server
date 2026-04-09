package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.objects.flat
import moe.crx.roadblock.updates.StatusUpdateGroup

@Serializable
open class UpdatesQueueWithRootReactionsResponse(
    var updates: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions(),
) : ResponsePacket() {
    fun flatten(vararg rootEntries: StatusUpdateGroup): UpdatesQueueWithRootReactionsResponse {
        updates = flat(*rootEntries)
        return this
    }
}