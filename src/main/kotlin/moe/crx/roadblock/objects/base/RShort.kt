package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

class RShort : RObject {

    var value: Short = 0

    override fun read(sink: InputSink) {
        value = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(value)
    }
}