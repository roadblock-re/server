package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ChampionshipRoundId
import moe.crx.roadblock.rpc.base.RequestPacket

class ChampionshipSpecialEventRefreshQualifyingRoundGroupRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var roundId: ChampionshipRoundId = 0
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        roundId = sink.readInt()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(roundId)
        sink.writeString(debugSuffix)
    }
}