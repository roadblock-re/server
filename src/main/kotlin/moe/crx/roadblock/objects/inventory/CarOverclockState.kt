package moe.crx.roadblock.objects.inventory

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class CarOverclockState(
    var overclockExpirationDateWithoutPass: Instant? = null,
    var overclockExpirationDate: Instant? = null,
)