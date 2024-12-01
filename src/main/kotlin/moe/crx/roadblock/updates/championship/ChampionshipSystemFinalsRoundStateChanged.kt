package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.championship.ChampionshipRoundState
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ChampionshipPoints
import moe.crx.roadblock.objects.game.ChampionshipRoundId

class ChampionshipSystemFinalsRoundStateChanged : RObject {

    var eventId: CalendarEventId = ""
    var roundId: ChampionshipRoundId = 0
    var state: ChampionshipRoundState = ChampionshipRoundState.Unknown
    var points: ChampionshipPoints = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        roundId = sink.readInt()
        state = sink.readEnum()
        points = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(roundId)
        sink.writeEnum(state)
        sink.writeInt(points)
    }
}