package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable

@Serializable
data class RewardBoosts(
    var creditsBoostPercentage: Float?,
    var tokensBoostPercentage: Float?,
    var rewardMultiplier: UInt?,
)