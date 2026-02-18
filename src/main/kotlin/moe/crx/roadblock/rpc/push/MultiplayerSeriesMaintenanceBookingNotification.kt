package moe.crx.roadblock.rpc.push

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.StatusUpdatesQueueWithRootReactions

class MultiplayerSeriesMaintenanceBookingNotification : PushMessagePacket() {

    var updates: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions()

    override fun read(sink: InputSink) {
        super.read(sink)
        updates = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(updates)
    }
}