package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

class RString : RObject {

    var value: String = ""

    override fun read(sink: InputSink) {
        value = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(value)
    }
}