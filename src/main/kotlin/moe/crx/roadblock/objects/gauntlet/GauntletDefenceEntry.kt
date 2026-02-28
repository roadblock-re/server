package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.GauntletScore

@Serializable
data class GauntletDefenceEntry(
    var myStats: List<GauntletRaceStats>,
    var opStats: List<GauntletRaceStats>,
    var opCredentials: Credentials,
    var myScore: GauntletScore,
    var opScore: GauntletScore,
    var timestamp: Instant,
    var revengeState: UInt,
    var dScore: GauntletScore,
)
