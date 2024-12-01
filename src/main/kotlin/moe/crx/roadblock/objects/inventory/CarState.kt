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
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort

class CarState : RObject {

    var carId: Int = 0
    var blueprints: Int = 0
    var unlockedTiers: Byte = 0
    var unlockedLevels: Byte = 0
    var carTuningState: List<CarStatState> = listOf()
    var epicItems: Int = 0
    var freeUpgrades: List<RInt> = listOf()
    var maintenanceStats: CarMaintenanceStats = CarMaintenanceStats()
    var usageState: CarUsageStats = CarUsageStats()
    var customizationState: CarCustomizationState = CarCustomizationState()
    var tierBlueprints: Int = 0
    var ownedDecalVisuals: List<RInt> = listOf()
    var isOwned: Boolean = false
    var isCarKeyOwned: Boolean = false
    var ownedCustomParts: List<RShort> = listOf()
    var currentEvoTier: RByte? = null
    var evoTierBlueprints: Int = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
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
        ownedCustomParts = sink.readList()
        isOwned = sink.readBoolean()
        isCarKeyOwned = sink.readBoolean()
        ownedDecalVisuals = sink.readList()
        currentEvoTier = sink.readOptional()
        evoTierBlueprints = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
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
        sink.writeList(ownedCustomParts)
        sink.writeBoolean(isOwned)
        sink.writeBoolean(isCarKeyOwned)
        sink.writeList(ownedDecalVisuals)
        sink.writeOptional(currentEvoTier)
        sink.writeInt(evoTierBlueprints)
    }
}