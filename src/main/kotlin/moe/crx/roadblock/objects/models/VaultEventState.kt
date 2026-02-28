package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.VaultStageId
import moe.crx.roadblock.objects.vault.VaultProgressionRewardsState
import moe.crx.roadblock.objects.vault.VaultStageState

@Serializable
data class VaultEventState(
    var eventExtendedData: VaultEventExtendedData,
    var stagesDataById: Map<VaultStageId, VaultStageState>,
    var progressionRewardsData: VaultProgressionRewardsState,
)