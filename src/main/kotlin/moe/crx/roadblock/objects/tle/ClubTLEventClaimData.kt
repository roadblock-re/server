package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnumUntil

@Serializable
data class ClubTLEventClaimData(
    @ByteEnumUntil("24.0.0")
    var state: ClubTLEventClaimState = ClubTLEventClaimState.Unknown,
    var finalProgress: List<UByte>,
    var claimableRewards: List<UByte>,
)