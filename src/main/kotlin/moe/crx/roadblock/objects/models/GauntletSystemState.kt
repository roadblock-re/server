package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.gauntlet.GauntletEventState
import moe.crx.roadblock.objects.gauntlet.GauntletMarketState

class GauntletSystemState : RObject {

    var eventDataById: Map<RString, GauntletEventState> = mapOf()
    var currentEventId: CalendarEventId = ""
    var market: GauntletMarketState = GauntletMarketState()

    override fun read(sink: InputSink) {
        eventDataById = sink.readMap()
        currentEventId = sink.readString()
        market = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(eventDataById)
        sink.writeString(currentEventId)
        sink.writeObject(market)
    }
}
