package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class TLSpecialData : RObject {

    var progressionLevels: List<RInt> = listOf()
    var progressionRewardStates: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        progressionLevels = sink.readList()
        progressionRewardStates = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(progressionLevels)
        sink.writeList(progressionRewardStates)
    }
}