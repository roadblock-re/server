package moe.crx.roadblock.updates.club

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class ClubSystemJoinedSeasonEvent : RObject {

    var id: CalendarEventId = ""

    override fun read(sink: InputSink) {
        id = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
    }
}