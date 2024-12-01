package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MultiplayerSeriesId
import moe.crx.roadblock.objects.game.PlayerElo
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerSeriesSetEloCheatRequest : RequestPacket() {

    var seriesId: MultiplayerSeriesId = 0
    var eventId: CalendarEventId = ""
    var elo: PlayerElo = 0f

    override fun read(sink: InputSink) {
        super.read(sink)
        seriesId = sink.readInt()
        eventId = sink.readString()
        elo = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(seriesId)
        sink.writeString(eventId)
        sink.writeFloat(elo)
    }
}