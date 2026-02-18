package moe.crx.roadblock.objects.inventory

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CarMaintenanceStats : RObject {

    var maintenanceSlots: Short = 0
    var isRefilling: Boolean = false
    var refillTime: Instant = now()
    var slotsBeforeRefill: Short = 0

    override fun read(sink: InputSink) {
        maintenanceSlots = sink.readShort()
        isRefilling = sink.readBoolean()
        refillTime = sink.readInstant()
        slotsBeforeRefill = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(maintenanceSlots)
        sink.writeBoolean(isRefilling)
        sink.writeInstant(refillTime)
        sink.writeShort(slotsBeforeRefill)
    }
}