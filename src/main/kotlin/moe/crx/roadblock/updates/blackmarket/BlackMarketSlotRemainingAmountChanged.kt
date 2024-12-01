package moe.crx.roadblock.updates.blackmarket

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.BlackMarketSlotId

class BlackMarketSlotRemainingAmountChanged : RObject {

    var slot: BlackMarketSlotId = 0
    var oldAmount: Int = 0
    var newAmount: Int = 0

    override fun read(sink: InputSink) {
        slot = sink.readByte()
        oldAmount = sink.readInt()
        newAmount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(slot)
        sink.writeInt(oldAmount)
        sink.writeInt(newAmount)
    }
}