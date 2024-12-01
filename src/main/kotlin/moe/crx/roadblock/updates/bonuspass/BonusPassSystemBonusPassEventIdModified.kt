package moe.crx.roadblock.updates.bonuspass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class BonusPassSystemBonusPassEventIdModified : RObject {

    var oldEventId: CalendarEventId = ""
    var newEventId: CalendarEventId = ""
    var duration: Instant = now()

    override fun read(sink: InputSink) {
        oldEventId = sink.readString()
        newEventId = sink.readString()
        duration = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(oldEventId)
        sink.writeString(newEventId)
        sink.writeInstant(duration)
    }
}