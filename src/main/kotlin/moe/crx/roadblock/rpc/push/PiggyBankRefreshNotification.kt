package moe.crx.roadblock.rpc.push

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.rpc.base.PushMessagePacket

@Serializable
data class PiggyBankRefreshNotification(
    var updates: StatusUpdatesQueueWithRootReactions,
) : PushMessagePacket()