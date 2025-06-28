package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RString(var value: String) : RObject {

    constructor() : this("")

    override fun read(sink: InputSink) {
        value = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(value)
    }
}