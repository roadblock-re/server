package moe.crx.roadblock.objects.quarantine

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class QuarantineEvidenceData(
    var sources: Set<QuarantineEvidenceSource>,
    var mostRecentTimePoint: Instant,
    var numberOfOccurrences: UInt,
)