package moe.crx.roadblock.objects.multiplayer

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.LeaderboardPosition
import moe.crx.roadblock.objects.account.PlayerElo

@Serializable
data class MultiplayerSeriesLeaderboardData(
    var timestamp: Instant,
    var myPosition: LeaderboardPosition,
    var firstPositionElo: PlayerElo,
    var secondPositionElo: PlayerElo,
)