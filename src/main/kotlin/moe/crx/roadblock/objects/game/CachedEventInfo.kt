package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CachedEventInfo : RObject {

    var eventId: CalendarEventId = ""
    var eventHash: Long = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        eventHash = sink.readLong()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeLong(eventHash)
    }
}