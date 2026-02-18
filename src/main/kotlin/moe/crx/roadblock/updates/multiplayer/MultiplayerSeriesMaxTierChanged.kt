package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MultiplayerSeriesTierInfo

class MultiplayerSeriesMaxTierChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldTier: MultiplayerSeriesTierInfo = MultiplayerSeriesTierInfo()
    var newTier: MultiplayerSeriesTierInfo = MultiplayerSeriesTierInfo()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldTier = sink.readObject()
        newTier = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeObject(oldTier)
        sink.writeObject(newTier)
    }
}