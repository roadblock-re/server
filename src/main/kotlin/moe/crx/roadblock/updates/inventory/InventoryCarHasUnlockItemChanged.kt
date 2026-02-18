package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId

class InventoryCarHasUnlockItemChanged : RObject {

    var carId: CarId = 0
    var isOwned: Boolean = false

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        isOwned = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeBoolean(isOwned)
    }
}