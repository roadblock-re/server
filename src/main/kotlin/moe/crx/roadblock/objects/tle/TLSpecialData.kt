package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
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