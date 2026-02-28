package moe.crx.roadblock.objects.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.inventory.CurrencyType

@Serializable
data class ActivationEventData(
    var activationExpirationDate: Instant,
    var currency: CurrencyType,
    var activationBlackMarketState: ActivationBlackMarketState,
    var seenLinkedEvents: List<CalendarEventId>,
)