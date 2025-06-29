package moe.crx.roadblock.objects.seasonalcurrency

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class SeasonalCurrencyEventData : RObject {

    var seasonalCurrencyExpirationDate: Instant = now()
    var eventId: CalendarEventId = ""

    override fun read(sink: InputSink) {
        seasonalCurrencyExpirationDate = sink.readInstant()
        eventId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(seasonalCurrencyExpirationDate)
        sink.writeString(eventId)
    }
}