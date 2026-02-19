package moe.crx.roadblock.objects.championship

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.LeaderboardPosition

@Serializable
data class ChampionshipLeaderboardData(
    var timestamp: Instant,
    var position: LeaderboardPosition,
)
