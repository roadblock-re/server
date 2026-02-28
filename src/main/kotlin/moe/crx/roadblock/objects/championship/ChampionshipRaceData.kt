package moe.crx.roadblock.objects.championship

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CarRank
import moe.crx.roadblock.objects.EvoTuningVisualArchetype

@Serializable
data class ChampionshipRaceData(
    var timeInMicroseconds: UInt,
    var carRank: CarRank,
    @FromVersion("24.0.0")
    var isCarOverclocked: Boolean = false,
    @FromVersion("47.1.0")
    var evoTuningVisualArchetype: EvoTuningVisualArchetype? = null,
)
