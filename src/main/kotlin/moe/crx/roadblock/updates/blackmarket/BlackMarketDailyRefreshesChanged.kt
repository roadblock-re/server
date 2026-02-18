package moe.crx.roadblock.updates.blackmarket

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.BlackMarketDailyRefreshes

class BlackMarketDailyRefreshesChanged : RObject {

    var oldRefreshes: BlackMarketDailyRefreshes = 0
    var newRefreshes: BlackMarketDailyRefreshes = 0

    override fun read(sink: InputSink) {
        oldRefreshes = sink.readByte()
        newRefreshes = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(oldRefreshes)
        sink.writeByte(newRefreshes)
    }
}