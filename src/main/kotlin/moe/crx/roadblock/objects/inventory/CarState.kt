package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.*
import moe.crx.roadblock.objects.game.Blueprints
import moe.crx.roadblock.objects.game.CarUpgradeLevel
import moe.crx.roadblock.objects.game.CarUpgradeTier
import moe.crx.roadblock.objects.game.UpgradeItems

class CarState : RObject {

    var blueprints: Blueprints = 0
    var unlockedTiers: CarUpgradeTier = 0
    var unlockedLevels: CarUpgradeLevel = 0
    var carTuning: List<CarStat> = listOf()
    var epicItems: UpgradeItems = 0
    var freeUpgrades: List<RInt> = listOf()
    var maintenance: CarMaintenanceStats = CarMaintenanceStats()
    var usageStats: CarUsageStats = CarUsageStats()
    var ownedEvoTuningParts: EvoTuningParts = EvoTuningParts()
    var customization: CarCustomizationState = CarCustomizationState()
    var tierBlueprints: Blueprints = 0
    var ownedDecalVisuals: List<RInt> = listOf()
    var isOwned: Boolean = false
    var isCarKeyOwned: Boolean = false
    var ownedCustomParts: List<RShort> = listOf()
    var currentEvoTier: RByte? = null
    var evoTierBlueprints: Blueprints = 0
    var overclockExpirationDate: RInstant? = null
    var unlockedAssemblyBlueprints: Int = 0

    override fun read(sink: InputSink) {
        blueprints = sink.readInt()
        unlockedTiers = sink.readByte()
        unlockedLevels = sink.readByte()
        carTuning = sink.readList()
        epicItems = sink.readInt()
        freeUpgrades = sink.readList()
        maintenance = sink.readObject()
        usageStats = sink.readObject()
        if (sink newer "45.0.0") {
            ownedEvoTuningParts = sink.readObject()
        }
        customization = sink.readObject()
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
        if (sink newer "24.6.0") {
            unlockedAssemblyBlueprints = sink.readInt()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(blueprints)
        sink.writeByte(unlockedTiers)
        sink.writeByte(unlockedLevels)
        sink.writeList(carTuning)
        sink.writeInt(epicItems)
        sink.writeList(freeUpgrades)
        sink.writeObject(maintenance)
        sink.writeObject(usageStats)
        if (sink newer "45.0.0") {
            sink.writeObject(ownedEvoTuningParts)
        }
        sink.writeObject(customization)
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
        if (sink newer "24.6.0") {
            sink.writeInt(unlockedAssemblyBlueprints)
        }
    }
}