package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable

@Serializable
data class ClubTLEventData(
    var completedRewards: List<UByte>,
    var claimedRewards: List<UByte>,
    var claimData: ClubTLEventClaimData,
)