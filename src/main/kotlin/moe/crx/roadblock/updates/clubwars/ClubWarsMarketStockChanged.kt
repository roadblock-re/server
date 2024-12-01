package moe.crx.roadblock.updates.clubwars

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ClubWarsMarketProductId

class ClubWarsMarketStockChanged : RObject {

    var productId: ClubWarsMarketProductId = 0

    override fun read(sink: InputSink) {
        productId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(productId)
    }
}