package moe.crx.roadblock.objects.championship

import kotlinx.serialization.Serializable

@Serializable
data class ChampionshipQualifyingStageData(
    var rounds: List<ChampionshipQualifyingRoundData>,
    var bestPracticeRace: ChampionshipRaceData,
    var obtainedRewardCounts: List<UInt>,
)