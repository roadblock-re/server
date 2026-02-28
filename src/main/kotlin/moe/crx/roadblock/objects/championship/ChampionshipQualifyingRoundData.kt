package moe.crx.roadblock.objects.championship

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ChampionshipGroupId
import moe.crx.roadblock.objects.quarantine.QuarantineEvidenceType

@Serializable
data class ChampionshipQualifyingRoundData(
    var groupId: ChampionshipGroupId,
    var attemptCount: UByte,
    var bestRace: ChampionshipRaceData,
    var leaderboard: ChampionshipLeaderboardData,
    var evidences: Map<QuarantineEvidenceType, ChampionshipEvidenceData>,
    var isDisqualified: Boolean,
    var state: ChampionshipRoundState,
)
