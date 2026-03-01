package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.StatusUpdateNode
import moe.crx.roadblock.objects.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.updates.StatusUpdateGroup

@Serializable
open class UpdatesQueueWithRootReactionsResponse(
    var updates: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions(),
) : ResponsePacket() {
    fun flatten(vararg rootEntries: StatusUpdateGroup): UpdatesQueueWithRootReactionsResponse {
        val statusUpdates: MutableList<StatusUpdateNode> = mutableListOf()
        val rootReactions: MutableList<UInt> = mutableListOf()

        rootEntries.forEach {
            val node = StatusUpdateNode(it, listOf())
            node.processNode(statusUpdates, rootReactions)
        }

        updates = StatusUpdatesQueueWithRootReactions(
            statusUpdates = statusUpdates,
            rootReactions = rootReactions
        )

        return this
    }

    private fun StatusUpdateNode.processNode(
        statusUpdates: MutableList<StatusUpdateNode>,
        parentReactions: MutableList<UInt>
    ) {
        val index = statusUpdates.size
        parentReactions.add(index.toUInt())
        statusUpdates.add(this)

        val childIndices = mutableListOf<UInt>()
        statusUpdate.children.forEach { childGroup ->
            val childNode = StatusUpdateNode(childGroup, listOf())
            childNode.processNode(statusUpdates, childIndices)
        }

        statusUpdates[index].reactions = childIndices
    }
}