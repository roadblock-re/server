package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MultiplayerSeriesId

class MultiplayerSeriesEventClaimable : RObject {

    var seriesId: MultiplayerSeriesId = 0
    var eventId: CalendarEventId = ""

    override fun read(sink: InputSink) {
        seriesId = sink.readInt()
        eventId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(seriesId)
        sink.writeString(eventId)
    }
}