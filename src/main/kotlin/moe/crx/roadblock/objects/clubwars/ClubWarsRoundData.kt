package moe.crx.roadblock.objects.clubwars

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubWarsBoardNodeId
import moe.crx.roadblock.objects.ClubWarsRegionId

@Serializable
data class ClubWarsRoundData(
    var refreshTimestamp: Instant,
    var registrationData: ClubWarsRegistrationData?,
    var defenseNodes: Map<ClubWarsRegionId, Map<ClubWarsBoardNodeId, ClubWarsRegionDefenseNodeData>>,
    var attackNodes: Map<ClubWarsRegionId, Map<ClubWarsBoardNodeId, ClubWarsRegionAttackNodeData>>,
    var forceRefreshRegistration: Boolean,
    var forceProcessMatchmaking: Boolean,
)