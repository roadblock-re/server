package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarVisualConfiguration

class InventoryCarVisualConfigurationChanged : RObject {

    var carId: CarId = 0
    var visualConfiguration: CarVisualConfiguration = CarVisualConfiguration()

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        visualConfiguration = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeObject(visualConfiguration)
    }
}