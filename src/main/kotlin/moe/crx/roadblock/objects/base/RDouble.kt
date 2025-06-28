package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RDouble(var value: Double) : RObject {

    constructor() : this(0.0)

    override fun read(sink: InputSink) {
        value = sink.readDouble()
    }

    override fun write(sink: OutputSink) {
        sink.writeDouble(value)
    }
}