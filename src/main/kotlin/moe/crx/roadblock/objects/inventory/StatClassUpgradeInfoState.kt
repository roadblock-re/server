package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class StatClassUpgradeInfoState : RObject {

    var rareItems: Int = 0
    var freeUpgrades: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        rareItems = sink.readInt()
        freeUpgrades = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(rareItems)
        sink.writeList(freeUpgrades)
    }
}