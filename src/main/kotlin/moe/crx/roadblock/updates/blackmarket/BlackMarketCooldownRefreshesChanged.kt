package moe.crx.roadblock.updates.blackmarket

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.blackmarket.BlackMarketItemVariant
import moe.crx.roadblock.objects.game.BlackMarketDailyRefreshes

class BlackMarketCooldownRefreshesChanged : RObject {

    var item: BlackMarketItemVariant = BlackMarketItemVariant()
    var oldRefreshes: BlackMarketDailyRefreshes = 0
    var newRefreshes: BlackMarketDailyRefreshes = 0

    override fun read(sink: InputSink) {
        item = sink.readObject()
        oldRefreshes = sink.readByte()
        newRefreshes = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(item)
        sink.writeByte(oldRefreshes)
        sink.writeByte(newRefreshes)
    }
}