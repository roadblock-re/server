package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion

@Serializable
data class ClubTLEventClaimData(
    @FromVersion("24.0.0")
    var state: ClubTLEventClaimState = ClubTLEventClaimState.Unknown,
    @UntilVersion("24.0.0") @ByteEnum
    var legacyState: ClubTLEventClaimState = ClubTLEventClaimState.Unknown,
    var finalProgress: List<UByte>,
    var claimableRewards: List<UByte>,
)