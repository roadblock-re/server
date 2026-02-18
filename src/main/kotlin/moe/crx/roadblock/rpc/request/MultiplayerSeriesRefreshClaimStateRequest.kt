package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MultiplayerSeriesId
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerSeriesRefreshClaimStateRequest : RequestPacket() {

    var seriesId: MultiplayerSeriesId = 0
    var eventId: CalendarEventId = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        seriesId = sink.readInt()
        eventId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(seriesId)
        sink.writeString(eventId)
    }
}