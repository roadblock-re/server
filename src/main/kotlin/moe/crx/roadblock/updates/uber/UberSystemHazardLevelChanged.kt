package moe.crx.roadblock.updates.uber

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.UberHazardLevel

class UberSystemHazardLevelChanged : RObject {

    var eventId: CalendarEventId = ""
    var hazardLevel: UberHazardLevel = 0
    var lastCleanTime: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        hazardLevel = sink.readInt()
        lastCleanTime = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(hazardLevel)
        sink.writeInstant(lastCleanTime)
    }

}