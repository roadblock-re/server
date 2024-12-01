package moe.crx.roadblock.objects.blackmarket

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class BlackMarketSlot : RObject {

    var item: BlackMarketItemVariant? = null
    var totalAmount: Int = 0
    var remainingAmount: Int = 0
    var currencyType: Int = 0
    var basePrice: Int = 0
    var stepAmount: Int = 0
    var slotType: Int = 0

    override fun read(sink: InputSink) {
        item = sink.readOptional()
        totalAmount = sink.readInt()
        remainingAmount = sink.readInt()
        currencyType = sink.readInt()
        basePrice = sink.readInt()
        stepAmount = sink.readInt()
        slotType = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(item)
        sink.writeInt(totalAmount)
        sink.writeInt(remainingAmount)
        sink.writeInt(currencyType)
        sink.writeInt(basePrice)
        sink.writeInt(stepAmount)
        sink.writeInt(slotType)
    }
}