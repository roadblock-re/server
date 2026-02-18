package moe.crx.roadblock.objects.item

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class BlackMarketItemVariant9 : RObject {

    var something: Int = 0

    override fun read(sink: InputSink) {
        something = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(something)
    }
}