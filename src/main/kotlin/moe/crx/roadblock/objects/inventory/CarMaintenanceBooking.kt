package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CarMaintenanceBooking : RObject {

    var carId: Int = 0
    var slots: Short = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        slots = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeShort(slots)
    }
}