package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable

@Serializable
data class ClubWarsParticipationData(
    var hasClaimedRewards: Boolean
)