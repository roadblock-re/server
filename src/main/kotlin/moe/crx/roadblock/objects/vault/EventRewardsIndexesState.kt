package moe.crx.roadblock.objects.vault

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.VaultStageId

@Serializable
data class EventRewardsIndexesState(
    var soloRewardsIndexesDataByStage: Map<VaultStageId, SoloRewardsIndexesState>,
    var progressionRewardsIndexesData: List<UInt>,
)