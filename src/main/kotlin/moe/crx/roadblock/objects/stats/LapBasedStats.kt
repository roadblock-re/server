package moe.crx.roadblock.objects.stats

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class LapBasedStats : RObject {

    var isDisqualified: Byte = 0

    override fun read(sink: InputSink) {
        isDisqualified = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(isDisqualified)
    }
}