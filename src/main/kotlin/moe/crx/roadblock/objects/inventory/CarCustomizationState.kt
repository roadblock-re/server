package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarVisualConfiguration

class CarCustomizationState : RObject {

    var visualConfiguration: CarVisualConfiguration = CarVisualConfiguration()
    var lockedCustomization: Boolean = false
    var lockedCalipers: Boolean = false
    var lockedRims: Boolean = false
    var lockedCarbonParts: Boolean = false
    var lockedNeonTubes: Boolean = false
    var lockedMaterialMetallic: Boolean = false
    var lockedMaterialMatte: Boolean = false
    var evoTuningPartsConfiguration: EvoTuningPartsConfiguration = EvoTuningPartsConfiguration()
    var lockedDualTone: Boolean = false
    var lockedMaterialMetallicRims: Boolean = false
    var lockedMaterialMatteRims: Boolean = false
    var lockedPaintJobs: Boolean = false
    var lockedDecals: Boolean = false
    var lockedTires: Boolean = false
    var lockedBodyParts: Boolean = false
    var lockedBodyPartsRoof: Boolean = false
    var lockedBodyPartsWing: Boolean = false
    var lockedBodyPartsSkirts: Boolean = false
    var lockedBodyPartsSpoilerFront: Boolean = false
    var lockedBodyPartsSpoilerRear: Boolean = false
    var lockedTintedGlass: Boolean = false
    var lockedLicensePlate: Boolean = false
    var lockedBodyPartsHood: Boolean = false
    var lockedBodyPartsTrunk: Boolean = false

    override fun read(sink: InputSink) {
        visualConfiguration = sink.readObject()
        lockedCustomization = sink.readBoolean()
        lockedCalipers = sink.readBoolean()
        lockedRims = sink.readBoolean()
        lockedCarbonParts = sink.readBoolean()
        lockedNeonTubes = sink.readBoolean()
        lockedMaterialMetallic = sink.readBoolean()
        lockedMaterialMatte = sink.readBoolean()
        if (sink newer "45.0.0") {
            evoTuningPartsConfiguration = sink.readObject()
        }
        lockedDualTone = sink.readBoolean()
        lockedMaterialMetallicRims = sink.readBoolean()
        lockedMaterialMatteRims = sink.readBoolean()
        lockedPaintJobs = sink.readBoolean()
        lockedDecals = sink.readBoolean()
        lockedTires = sink.readBoolean()
        lockedBodyParts = sink.readBoolean()
        lockedBodyPartsRoof = sink.readBoolean()
        lockedBodyPartsWing = sink.readBoolean()
        lockedBodyPartsSkirts = sink.readBoolean()
        lockedBodyPartsSpoilerFront = sink.readBoolean()
        lockedBodyPartsSpoilerRear = sink.readBoolean()
        lockedTintedGlass = sink.readBoolean()
        lockedLicensePlate = sink.readBoolean()
        lockedBodyPartsHood = sink.readBoolean()
        lockedBodyPartsTrunk = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(visualConfiguration)
        sink.writeBoolean(lockedCustomization)
        sink.writeBoolean(lockedCalipers)
        sink.writeBoolean(lockedRims)
        sink.writeBoolean(lockedCarbonParts)
        sink.writeBoolean(lockedNeonTubes)
        sink.writeBoolean(lockedMaterialMetallic)
        sink.writeBoolean(lockedMaterialMatte)
        if (sink newer "45.0.0") {
            sink.writeObject(evoTuningPartsConfiguration)
        }
        sink.writeBoolean(lockedDualTone)
        sink.writeBoolean(lockedMaterialMetallicRims)
        sink.writeBoolean(lockedMaterialMatteRims)
        sink.writeBoolean(lockedPaintJobs)
        sink.writeBoolean(lockedDecals)
        sink.writeBoolean(lockedTires)
        sink.writeBoolean(lockedBodyParts)
        sink.writeBoolean(lockedBodyPartsRoof)
        sink.writeBoolean(lockedBodyPartsWing)
        sink.writeBoolean(lockedBodyPartsSkirts)
        sink.writeBoolean(lockedBodyPartsSpoilerFront)
        sink.writeBoolean(lockedBodyPartsSpoilerRear)
        sink.writeBoolean(lockedTintedGlass)
        sink.writeBoolean(lockedLicensePlate)
        sink.writeBoolean(lockedBodyPartsHood)
        sink.writeBoolean(lockedBodyPartsTrunk)
    }
}