package moe.crx.roadblock.objects.uber

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class UberSpecialLevelData : RObject {

    var uberMarketSlots: List<UberMarketSlotState> = listOf()

    override fun read(sink: InputSink) {
        uberMarketSlots = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(uberMarketSlots)
    }

}
