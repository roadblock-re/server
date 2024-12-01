package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Blueprints
import moe.crx.roadblock.objects.game.CarId

class InventoryCarOwnedStateChanged : RObject {

    var carId: CarId = 0
    var isOwned: Boolean = false
    var oldBlueprintsForTier: Blueprints = 0
    var newBlueprintsForTier: Blueprints = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        isOwned = sink.readBoolean()
        oldBlueprintsForTier = sink.readInt()
        newBlueprintsForTier = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeBoolean(isOwned)
        sink.writeInt(oldBlueprintsForTier)
        sink.writeInt(newBlueprintsForTier)
    }
}