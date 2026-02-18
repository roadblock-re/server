package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.upsellpopup.UpsellPopupEvent

class UpsellPopupSystemState : RObject {

    var eventDataById: Map<RString, UpsellPopupEvent> = mapOf()
    var currentEventId: CalendarEventId = ""

    override fun read(sink: InputSink) {
        eventDataById = sink.readMap()
        currentEventId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(eventDataById)
        sink.writeString(currentEventId)
    }
}