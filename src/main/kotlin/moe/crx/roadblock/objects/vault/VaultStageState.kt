package moe.crx.roadblock.objects.vault

import kotlinx.serialization.Serializable

@Serializable
data class VaultStageState(
    var soloRewardsData: VaultSoloRewardsState,
)