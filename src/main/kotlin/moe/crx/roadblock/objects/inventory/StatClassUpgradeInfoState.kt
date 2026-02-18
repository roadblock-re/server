package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Blueprints

class StatClassUpgradeInfoState : RObject {

    var rareItems: Blueprints = 0
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