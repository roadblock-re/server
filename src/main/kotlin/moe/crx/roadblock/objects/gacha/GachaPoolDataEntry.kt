package moe.crx.roadblock.objects.gacha

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort

class GachaPoolDataEntry : RObject {

    var pulls: Map<RInt, RByte> = mapOf()
    var rewardPerSlotInUI: Map<RShort, GachaRewardPack> = mapOf()

    override fun read(sink: InputSink) {
        pulls = sink.readMap()
        if (sink newer "47.1.0") {
            rewardPerSlotInUI = sink.readMap()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(pulls)
        if (sink newer "47.1.0") {
            sink.writeMap(rewardPerSlotInUI)
        }
    }

}
