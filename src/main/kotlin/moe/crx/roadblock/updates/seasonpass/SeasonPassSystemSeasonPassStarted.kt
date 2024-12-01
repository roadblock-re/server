package moe.crx.roadblock.updates.seasonpass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.SeasonPassId

class SeasonPassSystemSeasonPassStarted : RObject {

    var eventId: CalendarEventId = ""
    var id: SeasonPassId = 0
    var isOnboarding: Boolean = false
    var endDate: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        id = sink.readInt()
        isOnboarding = sink.readBoolean()
        endDate = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(id)
        sink.writeBoolean(isOnboarding)
        sink.writeInstant(endDate)
    }
}