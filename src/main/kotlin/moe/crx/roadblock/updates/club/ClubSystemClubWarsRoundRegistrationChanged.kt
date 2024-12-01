package moe.crx.roadblock.updates.club

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex

class ClubSystemClubWarsRoundRegistrationChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldRegisteredRound: ClubWarsRoundIndex = 0
    var newRegisteredRound: ClubWarsRoundIndex = 0
    var newRegisteredTimestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldRegisteredRound = sink.readByte()
        newRegisteredRound = sink.readByte()
        newRegisteredTimestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(oldRegisteredRound)
        sink.writeByte(newRegisteredRound)
        sink.writeInstant(newRegisteredTimestamp)
    }
}