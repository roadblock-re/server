package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ChampionshipGroupId
import moe.crx.roadblock.objects.game.ChampionshipRoundId

class ChampionshipSystemQualifyingRoundGroupChanged : RObject {

    var eventId: CalendarEventId = ""
    var roundId: ChampionshipRoundId = 0
    var groupId: ChampionshipGroupId = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        roundId = sink.readInt()
        groupId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(roundId)
        sink.writeInt(groupId)
    }

}