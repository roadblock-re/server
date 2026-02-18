package moe.crx.roadblock.updates.club

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsPoints
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex

class ClubSystemClubWarsLastFinishedRoundChanged : RObject {

    var eventId: CalendarEventId = ""
    var lastFinishedRoundIndex: ClubWarsRoundIndex = 0
    var eventScoreAfterLastFinishedRound: ClubWarsPoints = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        lastFinishedRoundIndex = sink.readByte()
        eventScoreAfterLastFinishedRound = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(lastFinishedRoundIndex)
        sink.writeInt(eventScoreAfterLastFinishedRound)
    }
}