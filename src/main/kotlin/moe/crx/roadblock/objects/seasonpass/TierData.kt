package moe.crx.roadblock.objects.seasonpass

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum

@Serializable
data class TierData(
    @ByteEnum
    var freeRewardState: SeasonPassTierRewardState,
    @ByteEnum
    var premiumRewardState: SeasonPassTierRewardState,
)