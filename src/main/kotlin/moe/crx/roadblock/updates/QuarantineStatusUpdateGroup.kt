package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.quarantine.QuarantineEnterReason
import moe.crx.roadblock.objects.quarantine.QuarantineEvidence

@Serializable
sealed class QuarantineStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<QuarantineStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(QuarantineEvidenceAdded::class)
            add(QuarantineEntered::class)
            add(QuarantineEnterReasonChanged::class)
            add(QuarantineExited::class)
        }
    }
}

@Serializable
data class QuarantineEvidenceAdded(
    var evidence: QuarantineEvidence,
    var weight: Float,
) : QuarantineStatusUpdateGroup()

@Serializable
data class QuarantineEntered(
    var timePoint: Instant,
    var reason: QuarantineEnterReason,
) : QuarantineStatusUpdateGroup()

@Serializable
data class QuarantineEnterReasonChanged(
    var oldReason: QuarantineEnterReason,
    var newReason: QuarantineEnterReason,
) : QuarantineStatusUpdateGroup()

@Serializable
data class QuarantineExited(
    var timePoint: Instant,
    var reason: QuarantineEnterReason,
) : QuarantineStatusUpdateGroup()