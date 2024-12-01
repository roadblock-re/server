package moe.crx.roadblock.objects.bonuspass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TLEBenefitsState : RObject {

    var usedRefills: Int = 0
    var nextRefillsRestore: Instant = now()

    override fun read(sink: InputSink) {
        usedRefills = sink.readInt()
        nextRefillsRestore = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(usedRefills)
        sink.writeInstant(nextRefillsRestore)
    }
}