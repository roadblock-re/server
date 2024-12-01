package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort

class LegendFundSystemState : RObject {

    // TODO is this byte, short, or optional<short>?
    var ownedTierCount: Byte = 0
    var claimedMilestones: List<RShort> = listOf()

    override fun read(sink: InputSink) {
        ownedTierCount = sink.readByte()
        claimedMilestones = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(ownedTierCount)
        sink.writeList(claimedMilestones)
    }
}