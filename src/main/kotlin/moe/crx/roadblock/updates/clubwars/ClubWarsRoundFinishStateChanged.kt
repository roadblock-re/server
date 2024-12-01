package moe.crx.roadblock.updates.clubwars

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.clubwars.ClubWarsRoundFinishState
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex

class ClubWarsRoundFinishStateChanged : RObject {

    var eventId: CalendarEventId = ""
    var roundId: ClubWarsRoundIndex = 0
    var finishState: ClubWarsRoundFinishState = ClubWarsRoundFinishState.NotFinished

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        roundId = sink.readByte()
        finishState = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(roundId)
        sink.writeEnum(finishState)
    }
}