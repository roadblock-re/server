package moe.crx.roadblock.objects.miscellaneous

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.transactions.CustomMultiplierType

@Serializable
data class AdsExtraInformation(
    var userEventId: CalendarEventId?,
    var carId: CarId?,
    var customMultiplierType: CustomMultiplierType?,
)