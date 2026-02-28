package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.RelayOfferTierId

@Serializable
sealed class RelayOfferSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<RelayOfferSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(RelayOfferSystemCurrentTierChanged::class)
            add(RelayOfferSystemRemoveEvents::class)
            add(RelayOfferPurchaseTierUpdate::class)
        }
    }
}

@Serializable
data class RelayOfferPurchaseTierUpdate(
    var eventId: CalendarEventId,
    var purchasedTierId: RelayOfferTierId,
    var walletEventId: CalendarEventId?,
) : RelayOfferSystemStatusUpdateGroup()

@Serializable
data class RelayOfferSystemCurrentTierChanged(
    var eventId: CalendarEventId,
    var newCurrentTierId: RelayOfferTierId,
) : RelayOfferSystemStatusUpdateGroup()

@Serializable
data class RelayOfferSystemRemoveEvents(
    var eventIds: List<CalendarEventId>
) : RelayOfferSystemStatusUpdateGroup()