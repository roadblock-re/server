package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.updates.groups.StatusUpdateGroup

class StatusUpdatesQueueNode : RObject {

    var statusUpdate: StatusUpdateGroup = StatusUpdateGroup()
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