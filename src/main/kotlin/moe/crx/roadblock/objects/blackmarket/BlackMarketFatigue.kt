package moe.crx.roadblock.objects.blackmarket

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class BlackMarketFatigue : RObject {

    var item: BlackMarketItemVariant = BlackMarketItemVariant()
    var refreshes: Byte = 0

    override fun read(sink: InputSink) {
        item = sink.readObject()
        refreshes = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(item)
        sink.writeByte(refreshes)
    }
}