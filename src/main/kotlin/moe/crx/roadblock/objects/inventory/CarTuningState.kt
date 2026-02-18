package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import kotlin.collections.List

class CarTuningState : RObject {

    var stats: List<CarStat> = listOf()

    override fun read(sink: InputSink) {
        stats = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(stats)
    }
}