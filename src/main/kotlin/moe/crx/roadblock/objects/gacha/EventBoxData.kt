package moe.crx.roadblock.objects.gacha

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class EventBoxData : RObject {

    var gachaId: GachaId = GachaId()
    var openedCount: Int = 0
    var openedWithoutFeatureRewardCount: Int = 0

    override fun read(sink: InputSink) {
        gachaId = sink.readObject()
        openedCount = sink.readInt()
        openedWithoutFeatureRewardCount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(gachaId)
        sink.writeInt(openedCount)
        sink.writeInt(openedWithoutFeatureRewardCount)
    }
}