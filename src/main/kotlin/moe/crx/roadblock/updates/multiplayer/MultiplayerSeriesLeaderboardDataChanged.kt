package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.multiplayer.MultiplayerSeriesLeaderboardData

class MultiplayerSeriesLeaderboardDataChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldLeaderboardData: MultiplayerSeriesLeaderboardData? = null
    var newLeaderboardData: MultiplayerSeriesLeaderboardData = MultiplayerSeriesLeaderboardData()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldLeaderboardData = sink.readOptional()
        newLeaderboardData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeOptional(oldLeaderboardData)
        sink.writeObject(newLeaderboardData)
    }
}