package moe.crx.roadblock.objects.item

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CarUnlockItem : RObject {

    var carId: Int = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
    }
}