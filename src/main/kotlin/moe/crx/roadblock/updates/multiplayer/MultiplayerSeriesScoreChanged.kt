package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MultiplayerSeriesScore

class MultiplayerSeriesScoreChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldMultiplayerSeriesScore: MultiplayerSeriesScore = 0
    var newMultiplayerSeriesScore: MultiplayerSeriesScore = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldMultiplayerSeriesScore = sink.readInt()
        newMultiplayerSeriesScore = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(oldMultiplayerSeriesScore)
        sink.writeInt(newMultiplayerSeriesScore)
    }
}