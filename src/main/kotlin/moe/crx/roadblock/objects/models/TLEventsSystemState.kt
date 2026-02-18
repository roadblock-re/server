package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.tle.TLEventData
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.objects.tle.TLSpecialData

class TLEventsSystemState : RObject {

    var ticketBalance: Int = 0
    var lastTicketRefilledTime: Instant = now()
    var events: Map<TLEventId, TLEventData> = mapOf()
    var specialEvents: Map<RString, TLSpecialData> = mapOf()
    var isLocked: Boolean = false

    override fun read(sink: InputSink) {
        ticketBalance = sink.readInt()
        lastTicketRefilledTime = sink.readInstant()
        events = sink.readMap()
        specialEvents = sink.readMap()
        isLocked = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(ticketBalance)
        sink.writeInstant(lastTicketRefilledTime)
        sink.writeMap(events)
        sink.writeMap(specialEvents)
        sink.writeBoolean(isLocked)
    }
}