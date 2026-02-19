package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion

@Serializable
data class RankTLEventClaimData(
    @FromVersion("24.0.0")
    var state: RankTLEventClaimState = RankTLEventClaimState.Unknown,
    @UntilVersion("24.0.0") @ByteEnum
    var legacyState: RankTLEventClaimState = RankTLEventClaimState.Unknown,
    var rankRewardIdx: UByte,
)