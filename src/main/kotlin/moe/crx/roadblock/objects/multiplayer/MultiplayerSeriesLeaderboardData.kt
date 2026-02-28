package moe.crx.roadblock.objects.multiplayer

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.LeaderboardPosition
import moe.crx.roadblock.objects.PlayerElo

@Serializable
data class MultiplayerSeriesLeaderboardData(
    var timestamp: Instant,
    var myPosition: LeaderboardPosition,
    var firstPositionElo: PlayerElo,
    var secondPositionElo: PlayerElo,
)