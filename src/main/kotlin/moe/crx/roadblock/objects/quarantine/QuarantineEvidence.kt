package moe.crx.roadblock.objects.quarantine

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class QuarantineEvidence(
    var type: QuarantineEvidenceType,
    var source: QuarantineEvidenceSource,
    var timestamp: Instant,
)