package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class LatencyInfo : RObject {

    var latency: Double = 0.0

    override fun read(sink: InputSink) {
        latency = sink.readDouble()
    }

    override fun write(sink: OutputSink) {
        sink.writeDouble(latency)
    }
}