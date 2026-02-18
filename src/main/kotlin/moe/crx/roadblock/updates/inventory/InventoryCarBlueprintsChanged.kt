package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Blueprints
import moe.crx.roadblock.objects.game.CarId

class InventoryCarBlueprintsChanged : RObject {

    var carId: CarId = 0
    var oldBlueprints: Blueprints = 0
    var newBlueprints: Blueprints = 0
    var oldBlueprintsForTier: Blueprints = 0
    var newBlueprintsForTier: Blueprints = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        oldBlueprints = sink.readInt()
        newBlueprints = sink.readInt()
        oldBlueprintsForTier = sink.readInt()
        newBlueprintsForTier = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeInt(oldBlueprints)
        sink.writeInt(newBlueprints)
        sink.writeInt(oldBlueprintsForTier)
        sink.writeInt(newBlueprintsForTier)
    }
}