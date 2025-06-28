package moe.crx.roadblock.objects.base

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RInstant(var value: Instant) : RObject {

    constructor() : this(now())

    override fun read(sink: InputSink) {
        value = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(value)
    }
}