package moe.crx.roadblock.updates.playerstats

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ReputationPoints

class PlayerStatsReputationPointsOverflowed : RObject {

    var leftover: ReputationPoints = 0

    override fun read(sink: InputSink) {
        leftover = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(leftover)
    }
}