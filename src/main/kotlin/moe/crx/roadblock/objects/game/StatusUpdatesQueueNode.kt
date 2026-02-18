package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.updates.groups.StatusUpdateGroup

class StatusUpdatesQueueNode(ver: SerializationVersion) : RObject {

    var statusUpdate: StatusUpdateGroup = StatusUpdateGroup(ver)
    var reactions: List<RInt> = listOf() // UpdateReaction

    override fun read(sink: InputSink) {
        statusUpdate = sink.readObject()
        reactions = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(statusUpdate)
        sink.writeList(reactions)
    }
}