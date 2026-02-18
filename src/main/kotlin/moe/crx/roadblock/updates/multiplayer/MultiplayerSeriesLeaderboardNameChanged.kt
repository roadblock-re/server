package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CalendarEventId

class MultiplayerSeriesLeaderboardNameChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldLeaderboardName: RString? = null
    var newLeaderboardName: RString? = null

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldLeaderboardName = sink.readOptional()
        newLeaderboardName = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeOptional(oldLeaderboardName)
        sink.writeOptional(newLeaderboardName)
    }
}