package moe.crx.roadblock.objects.stats

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ChaseStats : RObject {

    var timeLeft: Int = 0
    var hasEscaped: Byte = 0

    override fun read(sink: InputSink) {
        timeLeft = sink.readInt()
        hasEscaped = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(timeLeft)
        sink.writeByte(hasEscaped)
    }
}