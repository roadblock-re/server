package moe.crx.roadblock.objects.vault

import kotlinx.serialization.Serializable

@Serializable
data class SoloRewardsIndexesState(
    var rewardsIndexesData: List<UInt>,
)