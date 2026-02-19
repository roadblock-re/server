package moe.crx.roadblock.objects.championship

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.quarantine.QuarantineEvidenceSource

@Serializable
data class ChampionshipEvidenceData(
    var sources: Set<QuarantineEvidenceSource>,
    var count: UInt,
    var timestamp: Instant,
)
