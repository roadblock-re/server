package moe.crx.roadblock.objects.uber

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class UberMarketSlotState : RObject {

    var timesPurchased: Int = 0

    override fun read(sink: InputSink) {
        timesPurchased = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(timesPurchased)
    }

}
