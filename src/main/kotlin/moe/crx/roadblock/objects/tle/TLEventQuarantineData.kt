package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable

@Serializable
data class TLEventQuarantineData(
    var leaderboardName: String,
    var bestRace: TLEventRaceData,
)