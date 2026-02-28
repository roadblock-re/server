package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarRank
import moe.crx.roadblock.objects.EvoTuningVisualArchetype

@Serializable
data class TLEventRaceData(
    var timeInMicroseconds: UInt,
    var carId: CarId,
    var carRank: CarRank,
    @FromVersion("24.0.0")
    var isCarOverclocked: Boolean = false,
    @FromVersion("24.6.0")
    var collectedItemCount: UInt = 0u,
    @FromVersion("24.6.0")
    var driveMeters: UInt = 0u,
    @FromVersion("47.1.0")
    var evoTuningVisualArchetype: EvoTuningVisualArchetype? = null,
)