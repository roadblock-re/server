package moe.crx.roadblock.updates.playerstats

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ReputationLevel

class PlayerStatsReputationLevelChanged : RObject {

    var oldLevel: ReputationLevel = 0
    var newLevel: ReputationLevel = 0

    override fun read(sink: InputSink) {
        oldLevel = sink.readInt()
        newLevel = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(oldLevel)
        sink.writeInt(newLevel)
    }
}