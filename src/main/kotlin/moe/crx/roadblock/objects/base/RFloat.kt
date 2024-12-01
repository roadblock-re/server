package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

class RFloat : RObject {

    var value: Float = 0f

    override fun read(sink: InputSink) {
        value = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(value)
    }
}