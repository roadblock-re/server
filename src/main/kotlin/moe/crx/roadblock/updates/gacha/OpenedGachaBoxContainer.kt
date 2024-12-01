package moe.crx.roadblock.updates.gacha

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.GachaId

class OpenedGachaBoxContainer : RObject {

    var gachaId: GachaId = 0
    var amountOfBoxesOpened: Int = 0

    override fun read(sink: InputSink) {
        gachaId = sink.readShort()
        amountOfBoxesOpened = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(gachaId)
        sink.writeInt(amountOfBoxesOpened)
    }
}