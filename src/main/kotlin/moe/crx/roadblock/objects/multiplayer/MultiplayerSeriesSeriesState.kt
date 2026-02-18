package moe.crx.roadblock.objects.multiplayer

import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RFloat
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class MultiplayerSeriesSeriesState : RObject {

    var eloOfLastClosedEvent: RFloat? = null
    var optLastClosedEventTimepoint: RInstant? = null
    var currentEventId: String = ""
    var events: Map<RString, MultiplayerSeriesEventState> = mapOf()

    override fun read(sink: InputSink) {
        eloOfLastClosedEvent = sink.readOptional()
        if (sink newer "24.6.0") {
            optLastClosedEventTimepoint = sink.readOptional()
        }
        currentEventId = sink.readString()
        events = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(eloOfLastClosedEvent)
        if (sink newer "24.6.0") {
            sink.writeOptional(optLastClosedEventTimepoint)
        }
        sink.writeString(currentEventId)
        sink.writeMap(events)
    }
}