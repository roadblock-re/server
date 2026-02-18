package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
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