package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class StatusUpdatesQueueWithRootReactions : RObject {

    var statusUpdates: List<StatusUpdatesQueueNode> = listOf()
    var rootReactions: List<RInt> = listOf() // UpdateReaction

    override fun read(sink: InputSink) {
        statusUpdates = sink.readList()
        rootReactions = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(statusUpdates)
        sink.writeList(rootReactions)
    }
}