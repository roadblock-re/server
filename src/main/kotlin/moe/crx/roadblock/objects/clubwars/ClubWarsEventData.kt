package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubWarsRoundIndex

@Serializable
data class ClubWarsEventData(
    var dataByRound: Map<ClubWarsRoundIndex, ClubWarsRoundData>,
    var claimData: ClubWarsClaimData,
)