package moe.crx.roadblock.objects.gacha

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.blackmarket.BlackMarketItemVariant

class GachaRewardPack : RObject {

    var item: BlackMarketItemVariant = BlackMarketItemVariant()
    var amount: Int = 0

    override fun read(sink: InputSink) {
        item = sink.readObject()
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(item)
        sink.writeInt(amount)
    }
}