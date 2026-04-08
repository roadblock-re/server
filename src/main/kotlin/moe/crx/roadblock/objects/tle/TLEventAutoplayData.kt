package moe.crx.roadblock.objects.tle

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TLEventAutoplayData(
    var finishTimepoint: Instant,
    var calculatedRewards: List<UByte>,
)