package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.GiftId

@Serializable
data class GiftSystemState(
    var claimedGifts: List<GiftId> = listOf(),
)