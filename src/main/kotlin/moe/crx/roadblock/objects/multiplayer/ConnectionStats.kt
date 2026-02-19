package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable

@Serializable
data class ConnectionStats(
    var averageRTT: Float = 0f,
    var worstRTT: Float = 0f,
    var averageJitter: Float = 0f,
    var slowPacketCount: UInt = 0u,
    var totalBytesSent: UInt = 0u,
    var totalBytesReceived: UInt = 0u,
    var lostPacketCount: UInt = 0u,
    var lostDataPacketPercentage: Float = 0f,
)