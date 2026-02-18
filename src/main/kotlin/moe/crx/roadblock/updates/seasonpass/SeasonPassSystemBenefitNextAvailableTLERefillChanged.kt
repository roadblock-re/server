package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

// Original name: SeasonPassSystemBenefitNextAvaiableTLERefillChanged
class SeasonPassSystemBenefitNextAvailableTLERefillChanged : RObject {

    var eventId: CalendarEventId = ""
    var nextAvailableTLERefillTimePoint: RInstant? = null

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        nextAvailableTLERefillTimePoint = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeOptional(nextAvailableTLERefillTimePoint)
    }
}