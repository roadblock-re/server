package moe.crx.roadblock.updates.blackmarket

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.blackmarket.BlackMarketSlot

class BlackMarketSlotsRefreshed : RObject {

    var slots: List<BlackMarketSlot> = listOf()

    override fun read(sink: InputSink) {
        slots = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(slots)
    }
}