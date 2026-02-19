package moe.crx.roadblock.objects.account

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TransferCode(
    var code: String = "",
    var expirationTime: Instant = now(),
)