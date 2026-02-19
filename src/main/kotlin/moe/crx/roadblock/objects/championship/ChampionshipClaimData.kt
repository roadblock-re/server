package moe.crx.roadblock.objects.championship

import kotlinx.serialization.Serializable

@Serializable
data class ChampionshipClaimData(
    var state: ChampionshipClaimState,
    var rankRewardIdx: UByte,
)