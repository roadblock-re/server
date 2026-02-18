package moe.crx.roadblock.updates.playerstats

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ReputationPoints

class PlayerStatsReputationPointsChanged : RObject {

    var oldPoints: ReputationPoints = 0
    var newPoints: ReputationPoints = 0
    var seasonPassBonusPoints: RInt? = null // ReputationPoints

    override fun read(sink: InputSink) {
        oldPoints = sink.readInt()
        newPoints = sink.readInt()
        seasonPassBonusPoints = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(oldPoints)
        sink.writeInt(newPoints)
        sink.writeOptional(seasonPassBonusPoints)
    }
}