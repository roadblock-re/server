package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Blueprints
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarUpgradeTier

class InventoryCarEvoTierBlueprintsChanged : RObject {

    var carId: CarId = 0
    var tier: CarUpgradeTier = 0
    var oldBlueprints: Blueprints = 0
    var newBlueprints: Blueprints = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        tier = sink.readByte()
        oldBlueprints = sink.readInt()
        newBlueprints = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeByte(tier)
        sink.writeInt(oldBlueprints)
        sink.writeInt(newBlueprints)
    }
}