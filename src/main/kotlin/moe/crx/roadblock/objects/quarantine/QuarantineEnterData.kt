package moe.crx.roadblock.objects.quarantine

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class QuarantineEnterData(
    var timePoint: Instant,
    var reason: QuarantineEnterReason,
)