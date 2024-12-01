package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

class RDouble : RObject {

    var value: Double = 0.0

    override fun read(sink: InputSink) {
        value = sink.readDouble()
    }

    override fun write(sink: OutputSink) {
        sink.writeDouble(value)
    }
}