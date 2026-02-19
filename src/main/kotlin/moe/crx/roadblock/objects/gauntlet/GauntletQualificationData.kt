package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class GauntletQualificationData(
    var qualificationStats: List<GauntletRaceStats>,
    var timestamp: Instant,
)
