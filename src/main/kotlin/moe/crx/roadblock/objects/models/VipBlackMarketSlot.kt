package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.blackmarket.BlackMarketItemVariant

class VipBlackMarketSlot : RObject {

    var item: BlackMarketItemVariant = BlackMarketItemVariant()
    var totalAmount: Int = 0
    var remainingPurchases: Int = 0
    var maxPurchases: Int = 0
    var currencyType: Int = 0
    var basePrice: Int = 0
    var stepAmount: Int = 0

    override fun read(sink: InputSink) {
        item = sink.readObject()
        totalAmount = sink.readInt()
        remainingPurchases = sink.readInt()
        maxPurchases = sink.readInt()
        currencyType = sink.readInt()
        basePrice = sink.readInt()
        stepAmount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(item)
        sink.writeInt(totalAmount)
        sink.writeInt(remainingPurchases)
        sink.writeInt(maxPurchases)
        sink.writeInt(currencyType)
        sink.writeInt(basePrice)
        sink.writeInt(stepAmount)
    }
}
