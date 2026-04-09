package moe.crx.roadblock.objects

import kotlinx.serialization.Serializable
import moe.crx.roadblock.updates.StatusUpdateGroup

@Serializable
data class StatusUpdatesQueueWithRootReactions(
    var statusUpdates: List<StatusUpdateNode> = listOf(),
    var rootReactions: List<UInt> = listOf(),
)

fun flat(vararg rootEntries: StatusUpdateGroup): StatusUpdatesQueueWithRootReactions {
    val statusUpdates: MutableList<StatusUpdateNode> = mutableListOf()
    val rootReactions: MutableList<UInt> = mutableListOf()

    rootEntries.forEach {
        val node = StatusUpdateNode(it, listOf())
        node.processNode(statusUpdates, rootReactions)
    }

    return StatusUpdatesQueueWithRootReactions(
        statusUpdates = statusUpdates,
        rootReactions = rootReactions
    )
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