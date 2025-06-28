package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RBoolean(var value: Boolean) : RObject {

    constructor() : this(false)

    override fun read(sink: InputSink) {
        value = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(value)
    }
}