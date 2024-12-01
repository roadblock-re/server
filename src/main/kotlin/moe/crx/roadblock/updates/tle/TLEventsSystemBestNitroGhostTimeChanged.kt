package moe.crx.roadblock.updates.tle

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemBestNitroGhostTimeChanged : RObject {

    var eventId: TLEventId = TLEventId()
    var timeInMicroseconds: Int = 0
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
        timeInMicroseconds = sink.readInt()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
        sink.writeInt(timeInMicroseconds)
        sink.writeInstant(timestamp)
    }
}