package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class CarStat : RObject {

    var currentUpgradeLevel: Byte = 0
    var upgradeItems: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        currentUpgradeLevel = sink.readByte()
        upgradeItems = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(currentUpgradeLevel)
        sink.writeList(upgradeItems)
    }
}