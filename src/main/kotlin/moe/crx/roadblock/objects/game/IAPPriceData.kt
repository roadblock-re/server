package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class IAPPriceData : RObject {

    var price: Float = 0f
    var displayPrice: String = ""

    override fun read(sink: InputSink) {
        price = sink.readFloat()
        displayPrice = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(price)
        sink.writeString(displayPrice)
    }
}