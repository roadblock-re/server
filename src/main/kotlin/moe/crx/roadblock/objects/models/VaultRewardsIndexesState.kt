package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.VaultEventId
import moe.crx.roadblock.objects.vault.EventRewardsIndexesState

@Serializable
data class VaultRewardsIndexesState(
    var rewardsIndexesDataById: Map<VaultEventId, EventRewardsIndexesState> = mapOf(),
)
