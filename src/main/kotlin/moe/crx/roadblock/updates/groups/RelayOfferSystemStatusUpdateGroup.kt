package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.relayoffer.RelayOfferPurchaseTierUpdate
import moe.crx.roadblock.updates.relayoffer.RelayOfferSystemCurrentTierChanged
import moe.crx.roadblock.updates.relayoffer.RelayOfferSystemRemoveEvents

class RelayOfferSystemStatusUpdateGroup : RVariant(
    RelayOfferSystemCurrentTierChanged::class,
    RelayOfferSystemRemoveEvents::class,
    RelayOfferPurchaseTierUpdate::class,
)