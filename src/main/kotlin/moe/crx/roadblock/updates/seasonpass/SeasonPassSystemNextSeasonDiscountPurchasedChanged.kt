package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class SeasonPassSystemNextSeasonDiscountPurchasedChanged : RObject {

    var eventId: CalendarEventId = ""
    var purchased: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        purchased = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeBoolean(purchased)
    }
}