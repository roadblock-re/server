package moe.crx.roadblock.updates.bonuspass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class BonusPassSystemBonusPassDurationModified : RObject {

    var eventId: CalendarEventId = ""
    var previousDuration: Instant = now()
    var newDuration: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        previousDuration = sink.readInstant()
        newDuration = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInstant(previousDuration)
        sink.writeInstant(newDuration)
    }
}