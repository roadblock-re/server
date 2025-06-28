package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

interface RObject {
    fun read(sink: InputSink)
    fun write(sink: OutputSink)
}
