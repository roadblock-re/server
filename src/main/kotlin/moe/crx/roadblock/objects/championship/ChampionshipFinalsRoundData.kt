package moe.crx.roadblock.objects.championship

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.ChampionshipPoints
import moe.crx.roadblock.objects.quarantine.QuarantineEvidenceType

@Serializable
data class ChampionshipFinalsRoundData(
    var attemptCount: UByte,
    @FromVersion("45.0.0")
    var obtainedRewardCounts: List<UInt> = listOf(),
    var bestPracticeRace: ChampionshipRaceData,
    var bestRace: ChampionshipRaceData,
    var leaderboard: ChampionshipLeaderboardData,
    @UntilVersion("45.0.0")
    var legacyObtainedRewardCounts: List<UInt> = listOf(),
    var evidences: Map<QuarantineEvidenceType, ChampionshipEvidenceData>,
    var isDisqualified: Boolean,
    var state: ChampionshipRoundState,
    var points: ChampionshipPoints,
)