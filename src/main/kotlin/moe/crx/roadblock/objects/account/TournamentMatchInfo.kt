package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class TournamentMatchInfo(
    var matchId: String,
    var status: UInt,
    var expirationTime: UInt,
    var cancellationTime: UInt?,
    var players: List<TournamentMatchPlayer>,
    var results: Map<String, UInt>?,
)