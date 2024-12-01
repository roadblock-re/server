package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RInt : RObject {

    var value: Int = 0

    override fun read(sink: InputSink) {
        value = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(value)
    }
}