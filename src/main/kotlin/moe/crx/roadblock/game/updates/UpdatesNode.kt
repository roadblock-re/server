package moe.crx.roadblock.game.updates

import moe.crx.roadblock.io.ObjectIO.createObject
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.objects.game.StatusUpdatesQueueNode
import moe.crx.roadblock.updates.groups.StatusUpdateGroup

class UpdatesNode(var update: RObject, vararg reactions: UpdatesNode) {

    companion object {
        fun RObject.toStatusUpdateGroup(ver: SerializationVersion): StatusUpdateGroup {
            return StatusUpdateGroup(ver).apply {
                variant = classes.first {
                    (ver.createObject(it) as? RVariant)?.classes?.contains(this@toStatusUpdateGroup::class) ?: false
                }.let {
                    val obj = ver.createObject(it)

                    if (obj is RVariant) {
                        obj.variant = this@toStatusUpdateGroup
                    }

                    obj
                }
            }
        }
    }

    var reactions: MutableList<UpdatesNode> = mutableListOf(*reactions)

    fun processNode(
        ver: SerializationVersion,
        statusUpdates: MutableList<StatusUpdatesQueueNode>,
        rootReactions: MutableList<RInt>
    ) {
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