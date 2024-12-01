package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MultiplayerSeriesId
import moe.crx.roadblock.objects.game.PlayerElo

class MultiplayerSeriesEventClaimed : RObject {

    var seriesId: MultiplayerSeriesId = 0
    var eventId: CalendarEventId = ""
    var eloForNextEvent: PlayerElo = 0.0f

    override fun read(sink: InputSink) {
        seriesId = sink.readInt()
        eventId = sink.readString()
        eloForNextEvent = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(seriesId)
        sink.writeString(eventId)
        sink.writeFloat(eloForNextEvent)
    }
}