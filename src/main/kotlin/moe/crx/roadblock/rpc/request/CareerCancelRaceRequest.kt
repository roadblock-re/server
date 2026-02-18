package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class CareerCancelRaceRequest : RequestPacket() {

    var raceId: RaceToken = 0
    var durationMicroseconds: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        raceId = sink.readInt()
        durationMicroseconds = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceId)
        sink.writeInt(durationMicroseconds)
    }
}