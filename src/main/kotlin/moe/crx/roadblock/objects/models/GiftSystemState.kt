package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.GiftId

@Serializable
data class GiftSystemState(
    var claimedGifts: List<GiftId> = listOf(),
)