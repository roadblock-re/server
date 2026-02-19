package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.*

@Serializable
data class GauntletChallengeEntry(
    var tracks: List<EventTrackDefId>,
    var myStats: List<GauntletRaceStats>,
    var opStats: List<GauntletRaceStats>,
    var opCredentials: Credentials,
    var myScore: GauntletScore,
    var opScore: GauntletScore,
    var challengePoints: GauntletChallengePoints,
    var loseChallengePoints: GauntletChallengePoints,
    var eloK: PlayerElo,
    var eloTa: List<PlayerElo>,
    var eloTd: List<PlayerElo>,
    var timestamp: Instant,
    var numFinished: UInt,
    var challengeType: UInt,
    var qualId: GauntletQualificationId,
)