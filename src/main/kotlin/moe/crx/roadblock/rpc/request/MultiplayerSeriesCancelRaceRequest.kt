package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MultiplayerSeriesId
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerSeriesCancelRaceRequest : RequestPacket() {

    var seriesId: MultiplayerSeriesId = 0
    var eventId: CalendarEventId = ""
    var raceToken: RaceToken = 0
    var raceTimeMicroseconds: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        seriesId = sink.readInt()
        eventId = sink.readString()
        raceToken = sink.readInt()
        raceTimeMicroseconds = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(seriesId)
        sink.writeString(eventId)
        sink.writeInt(raceToken)
        sink.writeInt(raceTimeMicroseconds)
    }
}