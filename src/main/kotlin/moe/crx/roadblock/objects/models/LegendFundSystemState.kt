package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort

class LegendFundSystemState : RObject {

    var ownedTierCount: Short = 0
    var claimedMilestones: List<RShort> = listOf()

    override fun read(sink: InputSink) {
        ownedTierCount = if (sink newer "24.0.0") {
            sink.readShort()
        } else {
            sink.readByte().toShort()
        }
        claimedMilestones = sink.readList()
    }

    override fun write(sink: OutputSink) {
        if (sink newer "24.0.0") {
            sink.writeShort(ownedTierCount)
        } else {
            sink.writeByte(ownedTierCount.toByte())
        }
        sink.writeList(claimedMilestones)
    }
}