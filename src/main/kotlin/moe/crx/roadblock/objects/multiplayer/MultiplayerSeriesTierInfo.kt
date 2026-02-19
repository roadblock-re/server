package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.MultiplayerSeriesSubTierId
import moe.crx.roadblock.objects.account.MultiplayerSeriesTierId

@Serializable
data class MultiplayerSeriesTierInfo(
    var tierId: MultiplayerSeriesTierId,
    @FromVersion("24.0.0")
    var subTierIndex: MultiplayerSeriesSubTierId = 0u,
)