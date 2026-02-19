package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.StatusUpdatesQueueWithRootReactions

@Serializable
open class UpdatesQueueWithRootReactionsResponse(
    var updatesQueue: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions(),
) : ResponsePacket()