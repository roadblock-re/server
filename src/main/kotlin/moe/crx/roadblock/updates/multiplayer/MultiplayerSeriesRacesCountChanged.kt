package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class MultiplayerSeriesRacesCountChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldCount: Int = 0
    var newCount: Int = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldCount = sink.readInt()
        newCount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(oldCount)
        sink.writeInt(newCount)
    }
}