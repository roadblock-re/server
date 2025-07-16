package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class SoloTLEventRewardData : RObject {

    var rewards: Map<RInt, RInt> = mapOf()

    override fun read(sink: InputSink) {
        rewards = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(rewards)
    }
}