package moe.crx.roadblock.updates.legendfund

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.GarageLevel

class LegendFundSystemLegendFundMilestoneClaimed : RObject {

    var level: GarageLevel = 0

    override fun read(sink: InputSink) {
        level = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(level)
    }
}