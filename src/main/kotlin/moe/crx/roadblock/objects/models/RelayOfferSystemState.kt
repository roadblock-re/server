package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.relayoffers.RelayOfferEventState

@Serializable
data class RelayOfferSystemState(
    var openedRelayOfferTiers: Map<CalendarEventId, RelayOfferEventState> = mapOf(),
)