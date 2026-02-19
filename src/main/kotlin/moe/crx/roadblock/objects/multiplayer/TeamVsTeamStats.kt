package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable

@Serializable
data class TeamVsTeamStats(
    var teamId: UInt = 0u,
    var points: UInt = 0u,
)