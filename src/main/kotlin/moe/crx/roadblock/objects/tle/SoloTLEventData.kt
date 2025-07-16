package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class SoloTLEventData : RObject {

    var obtainedRewardCounts: List<RInt> = listOf()
    var cumulativeRewardData: Map<RInt, SoloTLEventRewardData> = mapOf()

    override fun read(sink: InputSink) {
        obtainedRewardCounts = sink.readList()
        if (sink newer "24.6.0") {
            cumulativeRewardData = sink.readMap()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeList(obtainedRewardCounts)
        if (sink newer "24.6.0") {
            sink.writeMap(cumulativeRewardData)
        }
    }
}