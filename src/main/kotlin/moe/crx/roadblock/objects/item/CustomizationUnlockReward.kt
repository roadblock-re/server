package moe.crx.roadblock.objects.item

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId

class CustomizationUnlockReward : RObject {

    var carId: CarId = 0

    // TODO rework
    // 0 == DecalVisual, 1 == CustomPart
    var visualType: Byte = 0
    var visualId: Int = 0
    var partId: Short = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        visualType = sink.readByte()
        when (visualType.toInt()) {
            0 -> visualId = sink.readInt()
            1 -> partId = sink.readShort()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeByte(visualType)
        when (visualType.toInt()) {
            0 -> sink.writeInt(visualId)
            1 -> sink.writeShort(partId)
        }
    }
}