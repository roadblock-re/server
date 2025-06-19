package moe.crx.roadblock.push

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.objects.tle.EventDataVariant

class CalendarEventsLoaded : PushMessagePacket() {

    var events: List<EventDataVariant> = listOf()
    var updates: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions()

    override fun read(sink: InputSink) {
        super.read(sink)
        events = sink.readList()
        updates = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(events)
        sink.writeObject(updates)
    }
}