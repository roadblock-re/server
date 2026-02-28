package moe.crx.roadblock.objects.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.MultiplayerSeriesId
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.TriumphRewardId
import moe.crx.roadblock.objects.multiplayer.MultiplayerSeriesSeriesState

@Serializable
data class MultiplayerSeriesState(
    var series: Map<MultiplayerSeriesId, MultiplayerSeriesSeriesState> = mapOf(),
    var alreadyProcessedRaceTokenTransactions: List<RaceToken> = listOf(),
    var isLocked: Boolean = true,
    var mostRecentDisconnections: List<Instant> = listOf(),
    @FromVersion("24.0.0")
    var claimedTriumphRewardIds: List<TriumphRewardId> = listOf(),
)