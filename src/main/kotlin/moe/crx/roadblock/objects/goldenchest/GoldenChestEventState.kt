package moe.crx.roadblock.objects.goldenchest

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class GoldenChestEventState(
    var startDate: Instant,
    var lastChestIndexObtained: UInt?,
)