package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CarOfficialVisualIndex

@Serializable
data class FreeTryInfo(
    var visualId: CarOfficialVisualIndex?
)