package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CarEvoTuningPartId

@Serializable
data class EvoFreeTryData(
    var engineId: CarEvoTuningPartId?,
    var sKitId: CarEvoTuningPartId?,
    var intakeId: CarEvoTuningPartId?,
    var drivetrainId: CarEvoTuningPartId?,
    var nosId: CarEvoTuningPartId?,
)