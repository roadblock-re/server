package moe.crx.roadblock.objects.item

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CarCustomPart : RObject {

    var carId: Int = 0
    var partId: Short = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        partId = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeShort(partId)
    }
}