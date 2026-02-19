package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.customization.CarVisualConfiguration

@Serializable
data class CarCustomizationState(
    var visualConfiguration: CarVisualConfiguration = CarVisualConfiguration(),
    var lockedCustomization: Boolean = true,
    var lockedCalipers: Boolean = true,
    var lockedRims: Boolean = true,
    var lockedCarbonParts: Boolean = true,
    var lockedNeonTubes: Boolean = true,
    var lockedMaterialMetallic: Boolean = true,
    var lockedMaterialMatte: Boolean = true,
    @FromVersion("45.0.0")
    var evoTuningPartsConfiguration: EvoTuningPartsConfiguration = EvoTuningPartsConfiguration(),
    var lockedDualTone: Boolean = true,
    var lockedMaterialMetallicRims: Boolean = true,
    var lockedMaterialMatteRims: Boolean = true,
    var lockedPaintJobs: Boolean = true,
    var lockedDecals: Boolean = true,
    var lockedTires: Boolean = true,
    var lockedBodyParts: Boolean = true,
    var lockedBodyPartsRoof: Boolean = true,
    var lockedBodyPartsWing: Boolean = true,
    var lockedBodyPartsSkirts: Boolean = true,
    var lockedBodyPartsSpoilerFront: Boolean = true,
    var lockedBodyPartsSpoilerRear: Boolean = true,
    var lockedTintedGlass: Boolean = true,
    var lockedLicensePlate: Boolean = true,
    var lockedBodyPartsHood: Boolean = true,
    var lockedBodyPartsTrunk: Boolean = true,
)