package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class ClubWarsState : RObject {

    var events: Map<RString, ClubWarsEventData> = mapOf() // CalendarEventId
    var isLocked: Boolean = false

    override fun read(sink: InputSink) {
        events = sink.readMap()
        isLocked = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(events)
        sink.writeBoolean(isLocked)
    }
}