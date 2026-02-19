package moe.crx.roadblock.objects.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class VaultEventExtendedData(
    var startTimepoint: Instant,
    var durationInMinutes: UInt,
    var extendCount: UInt,
)