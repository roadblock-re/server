package moe.crx.roadblock.updates.tle

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemExitQuarantine : RObject {

    var eventId: TLEventId = TLEventId()
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
        sink.writeInstant(timestamp)
    }
}