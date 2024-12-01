package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MultiplayerSeriesId
import moe.crx.roadblock.objects.game.MultiplayerSeriesTierInfo
import moe.crx.roadblock.objects.game.PlayerElo

class MultiplayerSeriesEventJoined : RObject {

    var seriesId: MultiplayerSeriesId = 0
    var eventId: CalendarEventId = ""
    var eventElo: PlayerElo = 0.0f
    var enterTier: MultiplayerSeriesTierInfo = MultiplayerSeriesTierInfo()

    override fun read(sink: InputSink) {
        seriesId = sink.readInt()
        eventId = sink.readString()
        eventElo = sink.readFloat()
        enterTier = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(seriesId)
        sink.writeString(eventId)
        sink.writeFloat(eventElo)
        sink.writeObject(enterTier)
    }
}