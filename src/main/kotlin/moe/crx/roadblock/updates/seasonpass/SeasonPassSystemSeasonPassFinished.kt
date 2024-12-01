package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class SeasonPassSystemSeasonPassFinished : RObject {

    var eventId: CalendarEventId = ""

    override fun read(sink: InputSink) {
        eventId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
    }
}