package moe.crx.roadblock.objects.vault

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class VaultSoloRewardsState : RObject {

    var obtainedRewardCounts: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        obtainedRewardCounts = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(obtainedRewardCounts)
    }
}