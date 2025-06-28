package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RFloat(var value: Float) : RObject {

    constructor() : this(0f)

    override fun read(sink: InputSink) {
        value = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(value)
    }
}