package moe.crx.roadblock.objects.item

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class Currency : RObject {

    var currencyType: Int = 0

    override fun read(sink: InputSink) {
        currencyType = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(currencyType)
    }
}