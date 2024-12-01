package moe.crx.roadblock.updates.miscellaneous

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MiscellaneousRegionChangeCountChanged : RObject {

    var newValue: Int = 0

    override fun read(sink: InputSink) {
        newValue = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(newValue)
    }
}