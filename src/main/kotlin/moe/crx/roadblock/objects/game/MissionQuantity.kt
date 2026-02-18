package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MissionQuantity : RObject {

    var quantityVariant: Byte = 0
    var quantity: Int = 0

    override fun read(sink: InputSink) {
        quantityVariant = sink.readByte()
        quantity = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(quantityVariant)
        sink.writeInt(quantity)
    }
}