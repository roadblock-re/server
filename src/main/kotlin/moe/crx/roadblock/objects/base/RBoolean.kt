package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

class RBoolean : RObject {

    var value: Boolean = false

    override fun read(sink: InputSink) {
        value = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(value)
    }
}