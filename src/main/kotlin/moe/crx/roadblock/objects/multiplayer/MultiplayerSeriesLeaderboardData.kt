package moe.crx.roadblock.objects.multiplayer

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerSeriesLeaderboardData : RObject {

    var timestamp: Instant = now()
    var myPosition: Int = 0
    var firstPositionElo: Float = 0f
    var secondPositionElo: Float = 0f

    override fun read(sink: InputSink) {
        timestamp = sink.readInstant()
        myPosition = sink.readInt()
        firstPositionElo = sink.readFloat()
        secondPositionElo = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(timestamp)
        sink.writeInt(myPosition)
        sink.writeFloat(firstPositionElo)
        sink.writeFloat(secondPositionElo)
    }
}