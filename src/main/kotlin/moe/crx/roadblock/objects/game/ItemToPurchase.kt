package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ItemToPurchase : RObject {

    var itemId: String = ""
    var amount: Int = 0

    override fun read(sink: InputSink) {
        itemId = sink.readString()
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(itemId)
        sink.writeInt(amount)
    }
}