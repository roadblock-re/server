package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.StatusUpdatesQueueWithRootReactions

@Serializable
open class UpdatesQueueWithRootReactionsResponse(
    var updatesQueue: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions(),
) : ResponsePacket()