package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubWarsRewardIndex
import moe.crx.roadblock.objects.LeaderboardPosition

@Serializable
data class ClubWarsClaimData(
    var state: ClubWarsClaimState,
    var seasonRewardIdx: ClubWarsRewardIndex,
    var leaderboardPosition: LeaderboardPosition,
)