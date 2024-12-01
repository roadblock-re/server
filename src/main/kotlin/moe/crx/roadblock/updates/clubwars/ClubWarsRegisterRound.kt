package moe.crx.roadblock.updates.clubwars

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.*

class ClubWarsRegisterRound : RObject {

    var eventId: CalendarEventId = ""
    var roundId: ClubWarsRoundIndex = 0
    var clubId: ClubId = ""
    var clanGarageValue: GarageValue = 0
    var clanRegistrationPoints: ClubWarsPoints = 0
    var isParticipant: Boolean = false
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        roundId = sink.readByte()
        clubId = sink.readString()
        clanGarageValue = sink.readInt()
        clanRegistrationPoints = sink.readInt()
        isParticipant = sink.readBoolean()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(roundId)
        sink.writeString(clubId)
        sink.writeInt(clanGarageValue)
        sink.writeInt(clanRegistrationPoints)
        sink.writeBoolean(isParticipant)
        sink.writeInstant(timestamp)
    }
}