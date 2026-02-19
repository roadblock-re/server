package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable

@Serializable
data class DivergenceStats(
    var positionDivergenceGoodRTT: UInt = 0u,
    var extremePositionDivergenceGoodRTT: UInt = 0u,
    var positionDivergenceBadRTT: UInt = 0u,
    var extremePositionDivergenceBadRTT: UInt = 0u,
    var positionDivergenceVeryBadRTT: UInt = 0u,
    var extremePositionDivergenceVeryBadRTT: UInt = 0u,
    var discardedTakedownRatio: Float = 0f,
)