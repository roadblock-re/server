package moe.crx.roadblock.objects.account

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion

@Serializable
data class ActionRequestHeader(
    var actionId: UInt = 0u,
    var sessionId: String = "",
    @FromVersion("24.1.0")
    var clientTime: Instant = now(),
)