package moe.crx.roadblock.objects.relayoffers

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.RelayOfferTierId

@Serializable
data class RelayOfferEventState(
    var currentPurchasableTier: RelayOfferTierId,
    var amountOfPurchasesPerTier: Map<RelayOfferTierId, UByte>,
)