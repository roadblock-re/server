package moe.crx.roadblock.objects.vault

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.VaultEventProgressionRewardLevel
import moe.crx.roadblock.objects.VaultStageId

@Serializable
data class VaultProgressionRewardsState(
    var stagesProgressionLevel: Map<VaultStageId, VaultEventProgressionRewardLevel>,
    var progressionRewardsStatus: List<VaultEventProgressionRewardStatus>,
)