package moe.crx.roadblock.objects.bonuspass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class BonusPassState : RObject {

    var startDate: Instant = now()
    var bonusPassId: Int = 0
    var duration: Instant = now()

    override fun read(sink: InputSink) {
        startDate = sink.readInstant()
        bonusPassId = sink.readInt()
        duration = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(startDate)
        sink.writeInt(bonusPassId)
        sink.writeInstant(duration)
    }
}