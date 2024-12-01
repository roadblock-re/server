package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class ChampionshipSystemNitroGhostResetCountChanged : RObject {

    var eventId: CalendarEventId = ""
    var resetCount: Int = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        resetCount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(resetCount)
    }
}