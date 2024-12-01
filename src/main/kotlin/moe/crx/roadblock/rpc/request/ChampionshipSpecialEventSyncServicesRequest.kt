package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class ChampionshipSpecialEventSyncServicesRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeString(debugSuffix)
    }
}