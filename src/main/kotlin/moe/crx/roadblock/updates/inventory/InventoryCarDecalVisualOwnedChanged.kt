package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.DecalVisualId

class InventoryCarDecalVisualOwnedChanged : RObject {

    var carId: CarId = 0
    var visualId: DecalVisualId = 0
    var oldOwnedState: Boolean = false
    var newOwnedState: Boolean = false

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        visualId = sink.readInt()
        oldOwnedState = sink.readBoolean()
        newOwnedState = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeInt(visualId)
        sink.writeBoolean(oldOwnedState)
        sink.writeBoolean(newOwnedState)
    }
}