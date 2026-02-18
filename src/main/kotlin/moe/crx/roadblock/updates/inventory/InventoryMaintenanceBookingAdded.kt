package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.inventory.CarMaintenanceBooking

class InventoryMaintenanceBookingAdded : RObject {

    var booking: CarMaintenanceBooking = CarMaintenanceBooking()

    override fun read(sink: InputSink) {
        booking = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(booking)
    }
}