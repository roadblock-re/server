package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MaintenanceBooking : RObject {

    var cars: List<CarMaintenanceBooking> = listOf()

    override fun read(sink: InputSink) {
        cars = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(cars)
    }
}