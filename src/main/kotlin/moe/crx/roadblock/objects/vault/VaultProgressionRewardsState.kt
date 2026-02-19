package moe.crx.roadblock.objects.vault

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.VaultEventProgressionRewardLevel
import moe.crx.roadblock.objects.account.VaultStageId

@Serializable
data class VaultProgressionRewardsState(
    var stagesProgressionLevel: Map<VaultStageId, VaultEventProgressionRewardLevel>,
    var progressionRewardsStatus: List<VaultEventProgressionRewardStatus>,
)