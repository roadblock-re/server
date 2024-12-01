package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.MaintenanceSlots

class InventoryCarMaintenanceBalanceChanged : RObject {

    var carId: CarId = 0
    var oldSlots: MaintenanceSlots = 0
    var newSlots: MaintenanceSlots = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        oldSlots = sink.readShort()
        newSlots = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeShort(oldSlots)
        sink.writeShort(newSlots)
    }
}