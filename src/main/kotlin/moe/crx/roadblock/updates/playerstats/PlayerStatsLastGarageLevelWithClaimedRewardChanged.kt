package moe.crx.roadblock.updates.playerstats

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.GarageLevel

class PlayerStatsLastGarageLevelWithClaimedRewardChanged : RObject {

    var oldLevel: GarageLevel = 0
    var newLevel: GarageLevel = 0

    override fun read(sink: InputSink) {
        oldLevel = sink.readShort()
        newLevel = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(oldLevel)
        sink.writeShort(newLevel)
    }
}