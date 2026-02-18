package moe.crx.roadblock.objects.club

import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CalendarEventId

class ClubSeason : RObject {

    var eventId: CalendarEventId = ""
    var events: Map<RString, ClubSeasonEvent> = mapOf() // CalendarEventId

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        events = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeMap(events)
    }
}