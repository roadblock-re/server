package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.PlayerElo

class MultiplayerSeriesEloChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldElo: PlayerElo = 0.0f
    var newElo: PlayerElo = 0.0f

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldElo = sink.readFloat()
        newElo = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeFloat(oldElo)
        sink.writeFloat(newElo)
    }
}