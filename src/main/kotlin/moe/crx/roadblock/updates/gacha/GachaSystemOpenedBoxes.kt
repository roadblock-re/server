package moe.crx.roadblock.updates.gacha

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.gacha.GachaId

class GachaSystemOpenedBoxes : RObject {

    var gachaId: GachaId = GachaId()

    override fun read(sink: InputSink) {
        gachaId = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(gachaId)
    }
}