package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.MultiplayerSeriesScore
import moe.crx.roadblock.objects.MultiplayerSeriesScoreMilestoneId
import moe.crx.roadblock.objects.PlayerElo

@Serializable
data class MultiplayerSeriesEventState(
    var elo: PlayerElo,
    var leaderboardData: MultiplayerSeriesLeaderboardData?,
    var racesCount: UInt,
    var currentTier: MultiplayerSeriesTierInfo,
    var maxTier: MultiplayerSeriesTierInfo,
    var participationState: MultiplayerSeriesEventParticipationState,
    var leaderboardName: String?,
    var forceQuarantine: Boolean,
    var score: MultiplayerSeriesScore,
    var skippedBonusMilestones: List<MultiplayerSeriesScoreMilestoneId>,
    @FromVersion("24.0.0")
    var peakScore: MultiplayerSeriesScore = 0u,
)