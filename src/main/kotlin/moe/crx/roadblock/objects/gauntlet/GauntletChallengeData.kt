package moe.crx.roadblock.objects.gauntlet

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.GauntletChallengePoints
import moe.crx.roadblock.objects.GauntletScore
import moe.crx.roadblock.objects.social.Credentials

@Serializable
data class GauntletChallengeData(
    var tracks: List<EventTrackDefId>,
    var myStats: List<GauntletRaceStats>,
    var opStats: List<GauntletRaceStats>,
    var opCredentials: Credentials,
    var myScore: GauntletScore,
    var opScore: GauntletScore,
    var challengePoints: GauntletChallengePoints,
)
