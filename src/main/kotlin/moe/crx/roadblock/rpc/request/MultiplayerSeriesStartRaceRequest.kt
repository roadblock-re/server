package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerSeriesStartRaceRequest : RequestPacket() {

    var raceToken: RaceToken = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
    }
}