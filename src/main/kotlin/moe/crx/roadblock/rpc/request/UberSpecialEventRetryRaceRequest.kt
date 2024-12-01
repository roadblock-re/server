package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceStats
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class UberSpecialEventRetryRaceRequest : RequestPacket() {

    var raceToken: RaceToken = 0
    var raceStats: RaceStats = RaceStats()

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        raceStats = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeObject(raceStats)
    }
}