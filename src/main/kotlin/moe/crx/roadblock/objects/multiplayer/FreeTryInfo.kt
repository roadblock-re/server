package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable

@Serializable
data class FreeTryInfo(
    var visualId: CarVisualVariant?
)