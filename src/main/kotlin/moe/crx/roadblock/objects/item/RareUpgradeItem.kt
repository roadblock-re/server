package moe.crx.roadblock.objects.item

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class RareUpgradeItem : RObject {

    // TODO Check if it's int or byte
    var partType: Int = 0
    var partClass: Int = 0

    override fun read(sink: InputSink) {
        partType = sink.readInt()
        partClass = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(partType)
        sink.writeInt(partClass)
    }
}