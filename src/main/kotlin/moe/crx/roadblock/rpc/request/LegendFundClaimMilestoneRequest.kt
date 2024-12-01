package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.GarageLevel
import moe.crx.roadblock.rpc.base.RequestPacket

class LegendFundClaimMilestoneRequest : RequestPacket() {

    var level: GarageLevel = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        level = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeShort(level)
    }
}