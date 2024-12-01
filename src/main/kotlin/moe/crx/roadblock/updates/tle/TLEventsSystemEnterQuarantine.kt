package moe.crx.roadblock.updates.tle

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemEnterQuarantine : RObject {

    var eventId: TLEventId = TLEventId()
    var rankLeaderboardName: String = ""
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
        rankLeaderboardName = sink.readString()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
        sink.writeString(rankLeaderboardName)
        sink.writeInstant(timestamp)
    }
}