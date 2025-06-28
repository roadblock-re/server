package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RVector2F(var x: Float, var y: Float) : RObject {

    constructor() : this(0f, 0f)

    override fun read(sink: InputSink) {
        x = sink.readFloat()
        y = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(x)
        sink.writeFloat(y)
    }
}