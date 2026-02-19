package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ClubWarsBoardNodeId
import moe.crx.roadblock.objects.account.ClubWarsRegionId
import moe.crx.roadblock.objects.account.ClubWarsRoundIndex

@Serializable
data class ClubWarsNodeId(
    var roundId: ClubWarsRoundIndex,
    var regionId: ClubWarsRegionId,
    var nodeId: ClubWarsBoardNodeId,
)