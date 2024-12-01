package moe.crx.roadblock.updates.tle

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemClaimTopClubReward : RObject {

    var eventId: TLEventId = TLEventId()

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
    }
}