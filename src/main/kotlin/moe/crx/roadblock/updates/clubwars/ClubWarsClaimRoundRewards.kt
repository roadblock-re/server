package moe.crx.roadblock.updates.clubwars

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex

class ClubWarsClaimRoundRewards : RObject {

    var eventId: CalendarEventId = ""
    var roundId: ClubWarsRoundIndex = 0
    var won: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        roundId = sink.readByte()
        won = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(roundId)
        sink.writeBoolean(won)
    }
}