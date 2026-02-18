package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CustomPartId

class InventoryCarCustomPartOwnedChanged : RObject {

    var carId: CarId = 0
    var partId: CustomPartId = 0
    var oldOwnedState: Boolean = false
    var newOwnedState: Boolean = false

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        partId = sink.readShort()
        oldOwnedState = sink.readBoolean()
        newOwnedState = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeShort(partId)
        sink.writeBoolean(oldOwnedState)
        sink.writeBoolean(newOwnedState)
    }
}