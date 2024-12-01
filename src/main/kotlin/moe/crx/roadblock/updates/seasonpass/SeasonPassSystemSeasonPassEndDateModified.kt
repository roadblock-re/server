package moe.crx.roadblock.updates.seasonpass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class SeasonPassSystemSeasonPassEndDateModified : RObject {

    var eventId: CalendarEventId = ""
    var previousEndDate: Instant = now()
    var newEndDate: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        previousEndDate = sink.readInstant()
        newEndDate = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInstant(previousEndDate)
        sink.writeInstant(newEndDate)
    }
}