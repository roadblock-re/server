package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId

class InventoryCarIsClaimable : RObject {

    var carId: CarId = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
    }
}