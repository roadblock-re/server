package moe.crx.roadblock.objects.base

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

class RInstant : RObject {

    var value: Instant = now()

    override fun read(sink: InputSink) {
        value = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(value)
    }
}