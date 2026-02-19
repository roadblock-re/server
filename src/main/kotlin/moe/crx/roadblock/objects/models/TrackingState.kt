package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.objects.tracking.BannedState

@Serializable
data class TrackingState(
    var trackingToken: UInt = 0u,
    var gameTime: Float = 0f,
    var sessionId: UInt = 0u,
    var sessionTime: Float = 0f,
    @ByteEnum
    var trackingBannedState: BannedState? = null,
)