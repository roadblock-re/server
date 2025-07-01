package moe.crx.roadblock.game.updates

import moe.crx.roadblock.game.updates.UpdatesConverter.toStatusUpdateGroup
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.objects.game.StatusUpdatesQueueNode

class UpdatesNode(var update: RObject, vararg reactions: UpdatesNode) {

    var reactions: MutableList<UpdatesNode> = mutableListOf(*reactions)

    fun processNode(ver: SerializationVersion, statusUpdates: MutableList<StatusUpdatesQueueNode>, rootReactions: MutableList<RInt>) {
        val node = StatusUpdatesQueueNode(ver).apply {
            statusUpdate = update.toStatusUpdateGroup(ver)
            reactions =
                (statusUpdates.size + 1..statusUpdates.size + reactions.size).map { RInt().apply { value = it } }
        }

        rootReactions.add(RInt().apply { value = statusUpdates.size })
        statusUpdates.add(node)

        reactions.forEach {
            it.processNode(ver, statusUpdates, rootReactions)
        }
    }
}