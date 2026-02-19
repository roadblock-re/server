package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ClubWarsRewardIndex
import moe.crx.roadblock.objects.account.LeaderboardPosition

@Serializable
data class ClubWarsClaimData(
    var state: ClubWarsClaimState,
    var seasonRewardIdx: ClubWarsRewardIndex,
    var leaderboardPosition: LeaderboardPosition,
)