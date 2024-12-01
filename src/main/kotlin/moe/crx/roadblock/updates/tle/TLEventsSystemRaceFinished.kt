package moe.crx.roadblock.updates.tle

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemRaceFinished : RObject {

    var eventId: TLEventId = TLEventId()
    var position: Byte = 0
    var hasFinished: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
        position = sink.readByte()
        hasFinished = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
        sink.writeByte(position)
        sink.writeBoolean(hasFinished)
    }
}