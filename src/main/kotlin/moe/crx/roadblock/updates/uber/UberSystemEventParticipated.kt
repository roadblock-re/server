package moe.crx.roadblock.updates.uber

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class UberSystemEventParticipated : RObject {

    var eventId: CalendarEventId = ""
    var tierCount: Int = 0
    var levelCount: Int = 0
    var timePoint: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        tierCount = sink.readInt()
        levelCount = sink.readInt()
        timePoint = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(tierCount)
        sink.writeInt(levelCount)
        sink.writeInstant(timePoint)
    }
}