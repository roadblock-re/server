package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort
import moe.crx.roadblock.objects.game.Blueprints
import moe.crx.roadblock.objects.game.CarUpgradeLevel
import moe.crx.roadblock.objects.game.CarUpgradeTier
import moe.crx.roadblock.objects.game.UpgradeItems

class CarState : RObject {

    var blueprints: Blueprints = 0
    var unlockedTiers: CarUpgradeTier = 0
    var unlockedLevels: CarUpgradeLevel = 0
    var carTuningState: List<CarStatState> = listOf()
    var epicItems: UpgradeItems = 0
    var freeUpgrades: List<RInt> = listOf()
    var maintenanceStats: CarMaintenanceStats = CarMaintenanceStats()
    var usageState: CarUsageStats = CarUsageStats()
    var customizationState: CarCustomizationState = CarCustomizationState()
    var tierBlueprints: Blueprints = 0
    var ownedCustomParts: List<RShort> = listOf()
    var isOwned: Boolean = false
    var isCarKeyOwned: Boolean = false
    var ownedDecalVisuals: List<RInt> = listOf()
    var currentEvoTier: RByte? = null
    var evoTierBlueprints: Blueprints = 0
    var overclockExpirationDate: RInstant? = null

    override fun read(sink: InputSink) {
        blueprints = sink.readInt()
        unlockedTiers = sink.readByte()
        unlockedLevels = sink.readByte()
        carTuningState = sink.readList()
        epicItems = sink.readInt()
        freeUpgrades = sink.readList()
        maintenanceStats = sink.readObject()
        usageState = sink.readObject()
        customizationState = sink.readObject()
        tierBlueprints = sink.readInt()
        ownedDecalVisuals = sink.readList()
        isOwned = sink.readBoolean()
        isCarKeyOwned = sink.readBoolean()
        ownedCustomParts = sink.readList()
        if (sink older "24.0.0") {
            currentEvoTier = sink.readOptional()
            evoTierBlueprints = sink.readInt()
        }
        if (sink newer "24.0.0") {
            overclockExpirationDate = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(blueprints)
        sink.writeByte(unlockedTiers)
        sink.writeByte(unlockedLevels)
        sink.writeList(carTuningState)
        sink.writeInt(epicItems)
        sink.writeList(freeUpgrades)
        sink.writeObject(maintenanceStats)
        sink.writeObject(usageState)
        sink.writeObject(customizationState)
        sink.writeInt(tierBlueprints)
        sink.writeList(ownedDecalVisuals)
        sink.writeBoolean(isOwned)
        sink.writeBoolean(isCarKeyOwned)
        sink.writeList(ownedCustomParts)
        if (sink older "24.0.0") {
            sink.writeOptional(currentEvoTier)
            sink.writeInt(evoTierBlueprints)
        }
        if (sink newer "24.0.0") {
            sink.writeOptional(overclockExpirationDate)
        }
    }
}