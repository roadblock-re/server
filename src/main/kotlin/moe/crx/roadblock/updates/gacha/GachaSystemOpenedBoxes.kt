package moe.crx.roadblock.updates.gacha

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.GachaId

class GachaSystemOpenedBoxes : RObject {

    var gachaId: GachaId = 0

    override fun read(sink: InputSink) {
        gachaId = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(gachaId)
    }
}