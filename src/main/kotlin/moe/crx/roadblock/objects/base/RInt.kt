package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RInt(var value: Int) : RObject {

    constructor() : this(0)

    override fun read(sink: InputSink) {
        value = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(value)
    }
}