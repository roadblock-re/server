package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TRGBColor : RObject {

    var r: Float = 0f
    var g: Float = 0f
    var b: Float = 0f

    override fun read(sink: InputSink) {
        r = sink.readFloat()
        g = sink.readFloat()
        b = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(r)
        sink.writeFloat(g)
        sink.writeFloat(b)
    }
}