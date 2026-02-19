package moe.crx.roadblock.objects.inventory

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class CarOverclockState(
    var overclockExpirationDateWithoutPass: Instant? = now(),
    var overclockExpirationDate: Instant? = now(),
)