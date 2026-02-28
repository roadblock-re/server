package moe.crx.roadblock.objects.gauntlet

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.GauntletScore

@Serializable
data class GauntletOpponent(
    var tracks: List<EventTrackDefId>,
    var stats: List<GauntletRaceStats>,
    var score: GauntletScore,
    var qualId: GauntletScore,
    var credentials: Credentials,
)
