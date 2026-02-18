package moe.crx.roadblock.objects.base

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink

interface RObject {
    fun read(sink: InputSink)
    fun write(sink: OutputSink)
}
