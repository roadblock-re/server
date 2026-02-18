package moe.crx.roadblock.objects.club

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubId

class FirstClubData : RObject {

    var id: ClubId = ""
    var eventId: CalendarEventId = ""

    override fun read(sink: InputSink) {
        id = sink.readString()
        eventId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
        sink.writeString(eventId)
    }
}