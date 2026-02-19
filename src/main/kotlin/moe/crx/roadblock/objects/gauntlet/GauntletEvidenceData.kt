package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.quarantine.QuarantineEvidenceSource

@Serializable
data class GauntletEvidenceData(
    var sources: Set<QuarantineEvidenceSource>,
    var count: UInt,
    var timestamp: Instant,
)