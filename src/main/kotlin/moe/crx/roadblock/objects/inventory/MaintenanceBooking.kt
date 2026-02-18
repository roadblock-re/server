package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
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