package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class UberSystemCurrencyBeenConvertedChanged : RObject {

    var eventId: CalendarEventId = ""
    var hasBeenConverted: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        hasBeenConverted = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeBoolean(hasBeenConverted)
    }
}