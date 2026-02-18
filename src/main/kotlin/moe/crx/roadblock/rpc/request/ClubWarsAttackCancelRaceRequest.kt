package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubWarsAttackCancelRaceRequest : RequestPacket() {

    var raceToken: RaceToken = 0
    var raceTimeMicroseconds: Int = 0
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        raceTimeMicroseconds = sink.readInt()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeInt(raceTimeMicroseconds)
        sink.writeString(debugSuffix)
    }
}