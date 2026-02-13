package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
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