package moe.crx.roadblock.updates.gacha

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GachaSystemNextBoxIsCriticalChanged : RObject {

    var nextBoxIsCritical: Boolean = false

    override fun read(sink: InputSink) {
        nextBoxIsCritical = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(nextBoxIsCritical)
    }
}