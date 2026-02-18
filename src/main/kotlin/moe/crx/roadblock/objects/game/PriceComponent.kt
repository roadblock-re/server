package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class PriceComponent : RObject {

    var currencyType: Int = 0
    var amount: Int = 0

    override fun read(sink: InputSink) {
        currencyType = sink.readInt()
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(currencyType)
        sink.writeInt(amount)
    }
}