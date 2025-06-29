package moe.crx.roadblock.objects.championship

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.LeaderboardPosition

class ChampionshipLeaderboardData : RObject {

    var timestamp: Instant = now()
    var position: LeaderboardPosition = 0

    override fun read(sink: InputSink) {
        timestamp = sink.readInstant()
        position = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(timestamp)
        sink.writeInt(position)
    }

}
