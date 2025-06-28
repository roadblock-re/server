package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Blueprints

class StatUpgradeInfoState : RObject {

    var uncommonItems: Blueprints = 0
    var classInfo: List<StatClassUpgradeInfoState> = listOf()

    override fun read(sink: InputSink) {
        uncommonItems = sink.readInt()
        classInfo = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(uncommonItems)
        sink.writeList(classInfo)
    }
}