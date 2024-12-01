package moe.crx.roadblock.updates.bonuspass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class BonusPassSystemBenefitTLETicketsRefillsRestored : RObject {

    var newRestoreTime: Instant = now()

    override fun read(sink: InputSink) {
        newRestoreTime = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(newRestoreTime)
    }
}