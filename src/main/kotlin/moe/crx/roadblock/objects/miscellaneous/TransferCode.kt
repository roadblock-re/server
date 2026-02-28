package moe.crx.roadblock.objects.miscellaneous

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TransferCode(
    var code: String = "",
    var expirationTime: Instant = Clock.System.now(),
)