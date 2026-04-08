package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.TriumphRewardId

@Serializable
data class TriumphReward(
    var id: TriumphRewardId,
    var tier: MultiplayerSeriesTierInfo,
)
