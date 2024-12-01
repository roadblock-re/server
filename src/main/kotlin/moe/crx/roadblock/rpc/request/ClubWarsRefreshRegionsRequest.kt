package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RShort
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubWarsRefreshRegionsRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var roundId: ClubWarsRoundIndex = 0
    var regionsIds: List<RShort> = listOf() // ClubWarsRegionId
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        roundId = sink.readByte()
        regionsIds = sink.readList()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeByte(roundId)
        sink.writeList(regionsIds)
        sink.writeString(debugSuffix)
    }
}