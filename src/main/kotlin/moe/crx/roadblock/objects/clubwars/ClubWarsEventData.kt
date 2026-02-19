package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ClubWarsRoundIndex

@Serializable
data class ClubWarsEventData(
    var dataByRound: Map<ClubWarsRoundIndex, ClubWarsRoundData>,
    var claimData: ClubWarsClaimData,
)