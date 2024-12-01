package moe.crx.roadblock.updates.clubwars

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.clubwars.ClubWarsMatchmakingData
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex

class ClubWarsMatchmakingFinished : RObject {

    var eventId: CalendarEventId = ""
    var roundId: ClubWarsRoundIndex = 0
    var matchmakingData: ClubWarsMatchmakingData? = null

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        roundId = sink.readByte()
        matchmakingData = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(roundId)
        sink.writeOptional(matchmakingData)
    }
}