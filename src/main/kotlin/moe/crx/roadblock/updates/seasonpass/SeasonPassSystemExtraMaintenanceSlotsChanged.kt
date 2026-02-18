package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MaintenanceSlots

class SeasonPassSystemExtraMaintenanceSlotsChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldSlots: MaintenanceSlots = 0
    var newSlots: MaintenanceSlots = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldSlots = sink.readShort()
        newSlots = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeShort(oldSlots)
        sink.writeShort(newSlots)
    }
}