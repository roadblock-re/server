package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarEvoTuningPartId

@Serializable
data class EvoTuningPartsConfiguration(
    var engineId: CarEvoTuningPartId? = null,
    var driveTrainId: CarEvoTuningPartId? = null,
    var nosId: CarEvoTuningPartId? = null,
    var intakeId: CarEvoTuningPartId? = null,
    var sKitId: CarEvoTuningPartId? = null,
)