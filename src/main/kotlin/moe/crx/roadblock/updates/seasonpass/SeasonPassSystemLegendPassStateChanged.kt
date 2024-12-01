package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class SeasonPassSystemLegendPassStateChanged : RObject {

    var eventId: CalendarEventId = ""
    var legendPassType: RInt? = null // SeasonPassLegendPassType

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        legendPassType = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeOptional(legendPassType)
    }
}