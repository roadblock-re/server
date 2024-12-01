package moe.crx.roadblock.objects.gacha

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class EventBoxData : RObject {

    var gachaId: Short = 0
    var openedCount: Int = 0
    var openedWithoutFeatureRewardCount: Int = 0

    override fun read(sink: InputSink) {
        gachaId = sink.readShort()
        openedCount = sink.readInt()
        openedWithoutFeatureRewardCount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(gachaId)
        sink.writeInt(openedCount)
        sink.writeInt(openedWithoutFeatureRewardCount)
    }
}