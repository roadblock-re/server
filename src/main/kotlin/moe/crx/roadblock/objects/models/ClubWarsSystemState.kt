package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.clubwars.ClubWarsMarketState
import moe.crx.roadblock.objects.clubwars.ClubWarsState

@Serializable
data class ClubWarsSystemState(
    var state: ClubWarsState = ClubWarsState(),
    var market: ClubWarsMarketState = ClubWarsMarketState(),
)