package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.MaintenanceBookingRemoveReason
import moe.crx.roadblock.objects.inventory.CarMaintenanceBooking

class InventoryMaintenanceBookingRemoved : RObject {

    var booking: CarMaintenanceBooking = CarMaintenanceBooking()
    var reason: MaintenanceBookingRemoveReason = MaintenanceBookingRemoveReason.Committed

    override fun read(sink: InputSink) {
        booking = sink.readObject()
        reason = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(booking)
        sink.writeEnum(reason)
    }
}