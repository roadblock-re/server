package moe.crx.roadblock.updates.inventory

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId

class InventoryCarMaintenanceStateChanged : RObject {

    var carId: CarId = 0
    var oldIsRefilling: Boolean = false
    var newIsRefilling: Boolean = false
    var oldEndRefillTime: Instant = now()
    var newEndRefillTime: Instant = now()

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        oldIsRefilling = sink.readBoolean()
        newIsRefilling = sink.readBoolean()
        oldEndRefillTime = sink.readInstant()
        newEndRefillTime = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeBoolean(oldIsRefilling)
        sink.writeBoolean(newIsRefilling)
        sink.writeInstant(oldEndRefillTime)
        sink.writeInstant(newEndRefillTime)
    }
}