package moe.crx.roadblock.updates.tle

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.TimeLimitedEventProgressionLevel
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemSpecialEventProgressionChanged : RObject {

    var eventId: TLEventId = TLEventId()
    var progression: TimeLimitedEventProgressionLevel = 0

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
        progression = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
        sink.writeInt(progression)
    }
}