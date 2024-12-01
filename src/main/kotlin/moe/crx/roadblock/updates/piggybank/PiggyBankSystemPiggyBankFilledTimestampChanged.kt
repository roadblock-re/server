package moe.crx.roadblock.updates.piggybank

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class PiggyBankSystemPiggyBankFilledTimestampChanged : RObject {

    var eventId: CalendarEventId = ""
    var filledTimestamp: RInstant? = null

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        filledTimestamp = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeOptional(filledTimestamp)
    }
}