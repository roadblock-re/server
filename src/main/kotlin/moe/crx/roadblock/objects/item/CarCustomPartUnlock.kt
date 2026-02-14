package moe.crx.roadblock.objects.item

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CarCustomPartUnlock : RObject {

    var partId: Short = 0

    override fun read(sink: InputSink) {
        partId = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(partId)
    }
}