package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubWarsClaimRoundRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var roundId: ClubWarsRoundIndex = 0
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        roundId = sink.readByte()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeByte(roundId)
        sink.writeString(debugSuffix)
    }
}