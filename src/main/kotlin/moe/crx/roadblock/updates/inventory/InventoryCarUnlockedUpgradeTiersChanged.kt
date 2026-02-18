package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Blueprints
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarUpgradeLevel
import moe.crx.roadblock.objects.game.CarUpgradeTier

class InventoryCarUnlockedUpgradeTiersChanged : RObject {

    var carId: CarId = 0
    var oldTiers: CarUpgradeTier = 0
    var newTiers: CarUpgradeTier = 0
    var oldAvailableLevels: CarUpgradeLevel = 0
    var newAvailableLevels: CarUpgradeLevel = 0
    var oldBlueprintsForTier: Blueprints = 0
    var newBlueprintsForTier: Blueprints = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        oldTiers = sink.readByte()
        newTiers = sink.readByte()
        oldAvailableLevels = sink.readByte()
        newAvailableLevels = sink.readByte()
        oldBlueprintsForTier = sink.readInt()
        newBlueprintsForTier = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeByte(oldTiers)
        sink.writeByte(newTiers)
        sink.writeByte(oldAvailableLevels)
        sink.writeByte(newAvailableLevels)
        sink.writeInt(oldBlueprintsForTier)
        sink.writeInt(newBlueprintsForTier)
    }
}