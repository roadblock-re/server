package moe.crx.roadblock.updates.championship

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class ChampionshipSystemClaimFreePack : RObject {

    var eventId: CalendarEventId = ""
    var newFreePackClaimTimePoint: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        newFreePackClaimTimePoint = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInstant(newFreePackClaimTimePoint)
    }
}