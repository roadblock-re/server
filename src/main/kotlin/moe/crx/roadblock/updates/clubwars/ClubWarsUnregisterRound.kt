package moe.crx.roadblock.updates.clubwars

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex

class ClubWarsUnregisterRound : RObject {

    var eventId: CalendarEventId = ""
    var roundId: ClubWarsRoundIndex = 0
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        roundId = sink.readByte()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(roundId)
        sink.writeInstant(timestamp)
    }
}