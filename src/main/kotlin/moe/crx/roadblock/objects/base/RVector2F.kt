package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

class RVector2F : RObject {

    var x: Float = 0f
    var y: Float = 0f

    override fun read(sink: InputSink) {
        x = sink.readFloat()
        y = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(x)
        sink.writeFloat(y)
    }
}