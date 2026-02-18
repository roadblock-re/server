package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ChampionshipRoundId

class ChampionshipSystemIsQualifiedChanged : RObject {

    var eventId: CalendarEventId = ""
    var isQualified: Boolean = false
    var roundId: ChampionshipRoundId = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        isQualified = sink.readBoolean()
        roundId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeBoolean(isQualified)
        sink.writeInt(roundId)
    }
}