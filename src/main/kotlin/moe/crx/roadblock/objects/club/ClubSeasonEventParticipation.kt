package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ReputationPoints

@Serializable
data class ClubSeasonEventParticipation(
    var score: ReputationPoints,
)