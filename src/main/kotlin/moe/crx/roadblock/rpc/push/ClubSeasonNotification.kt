package moe.crx.roadblock.rpc.push

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.rpc.base.PushMessagePacket

@Serializable
data class ClubSeasonNotification(
    var updates: StatusUpdatesQueueWithRootReactions,
) : PushMessagePacket()