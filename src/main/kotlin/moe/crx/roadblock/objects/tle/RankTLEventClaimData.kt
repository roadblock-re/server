package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnumUntil

@Serializable
data class RankTLEventClaimData(
    @ByteEnumUntil("24.0.0")
    var state: RankTLEventClaimState = RankTLEventClaimState.Unknown,
    var rankRewardIdx: UByte,
)