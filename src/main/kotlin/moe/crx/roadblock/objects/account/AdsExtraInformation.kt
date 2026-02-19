package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class AdsExtraInformation(
    var userEventId: CalendarEventId?,
    var carId: CarId?,
    var customMultiplierType: CustomMultiplierType?,
)