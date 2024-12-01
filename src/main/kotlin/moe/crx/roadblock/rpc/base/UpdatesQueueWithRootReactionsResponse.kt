package moe.crx.roadblock.rpc.base

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.StatusUpdatesQueueWithRootReactions

abstract class UpdatesQueueWithRootReactionsResponse() : ResponsePacket() {

    var updatesQueue: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions()

    override fun read(sink: InputSink) {
        super.read(sink)
        updatesQueue = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(updatesQueue)
    }
}