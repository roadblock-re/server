package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class UberSpecialEventCancelRaceRequest : RequestPacket() {

    var raceToken: RaceToken = 0
    var raceTimeMicroseconds: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        raceTimeMicroseconds = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeInt(raceTimeMicroseconds)
    }
}