package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class ChampionshipSystemRaceFinished : RObject {

    var eventId: CalendarEventId = ""
    var hasFinished: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        hasFinished = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeBoolean(hasFinished)
    }
}