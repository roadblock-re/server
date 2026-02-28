package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarEvoTuningPartId

@Serializable
data class EvoTuningParts(
    var ownedEngineIds: List<CarEvoTuningPartId> = listOf(),
    var ownedDriveTrainIds: List<CarEvoTuningPartId> = listOf(),
    var ownedNOSIds: List<CarEvoTuningPartId> = listOf(),
    var ownedIntakeIds: List<CarEvoTuningPartId> = listOf(),
    var ownedSKitIds: List<CarEvoTuningPartId> = listOf(),
)
