package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
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