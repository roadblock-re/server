package moe.crx.roadblock.objects.gacha

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion

@Serializable
data class GachaPoolDataEntry(
    var pulls: Map<UInt, UByte>,
    @FromVersion("47.1.0")
    var rewardPerSlotInUI: Map<UShort, GachaRewardPack> = mapOf(),
)