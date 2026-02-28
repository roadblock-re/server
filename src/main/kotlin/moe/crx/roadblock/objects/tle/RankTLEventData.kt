package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.LeaderboardPosition

@Serializable
data class RankTLEventData(
    var leaderboardPosition: LeaderboardPosition,
    var entryCount: UInt,
    var claimData: RankTLEventClaimData,
)