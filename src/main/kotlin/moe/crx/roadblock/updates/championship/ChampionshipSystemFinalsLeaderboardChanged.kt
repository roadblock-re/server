package moe.crx.roadblock.updates.championship

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.LeaderboardPosition

class ChampionshipSystemFinalsLeaderboardChanged : RObject {

    var eventId: CalendarEventId = ""
    var position: LeaderboardPosition = 0
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        position = sink.readInt()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(position)
        sink.writeInstant(timestamp)
    }
}