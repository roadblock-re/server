package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.account.GauntletScore

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
