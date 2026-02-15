package moe.crx.roadblock.game.updates

import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.serialization.SerializationVersion
import moe.crx.roadblock.objects.game.StatusUpdatesQueueNode
import moe.crx.roadblock.objects.game.StatusUpdatesQueueWithRootReactions

class UpdatesTree(vararg reactions: UpdatesNode) {

    val rootEntries: MutableList<UpdatesNode> = mutableListOf(*reactions)

    fun flatten(ver: SerializationVersion): StatusUpdatesQueueWithRootReactions {
        val statusUpdates: MutableList<StatusUpdatesQueueNode> = mutableListOf()
        val rootReactions: MutableList<RInt> = mutableListOf()

        rootEntries.forEach {
            it.processNode(ver, statusUpdates, rootReactions)
        }

        return StatusUpdatesQueueWithRootReactions().apply {
            this.statusUpdates = statusUpdates
            this.rootReactions = rootReactions
        }
    }
}