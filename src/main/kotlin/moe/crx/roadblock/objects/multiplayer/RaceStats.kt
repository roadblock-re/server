package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.enumListOf

@Serializable
data class RaceStats(
    var oneBasedPosition: UByte = 0u,
    var intStats: EnumList<UInt, RaceIntegerStats> = enumListOf { 0u },
    var timeStats: EnumList<UInt, RaceTimeStats> = enumListOf { 0u },
    var playModeStats: PlayModeStats? = null,
    var playModeType: PlayModeType? = null,
    @FromVersion("45.0.0")
    var teamVsTeamStats: TeamVsTeamStats? = TeamVsTeamStats(),
)