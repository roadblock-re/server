package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubWarsBoardNodeId
import moe.crx.roadblock.objects.ClubWarsRegionId
import moe.crx.roadblock.objects.ClubWarsRoundIndex

@Serializable
data class ClubWarsNodeId(
    var roundId: ClubWarsRoundIndex,
    var regionId: ClubWarsRegionId,
    var nodeId: ClubWarsBoardNodeId,
)