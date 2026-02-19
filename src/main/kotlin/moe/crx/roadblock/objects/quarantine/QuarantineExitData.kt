package moe.crx.roadblock.objects.quarantine

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class QuarantineExitData(
    var timePoint: Instant,
    var reason: QuarantineExitReason,
    var evidences: Map<QuarantineEvidenceType, QuarantineEvidenceData>,
)