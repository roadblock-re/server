package moe.crx.roadblock.objects.vault

import kotlinx.serialization.Serializable

@Serializable
data class VaultSoloRewardsState(
    var obtainedRewardCounts: List<UInt>,
)