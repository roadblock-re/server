package moe.crx.roadblock.objects.account

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class ActionResponseHeader(
    var nextActionId: UInt = 0u,
    var lastCommittedActionId: UInt = 0u,
    var serverTime: Instant = now(),
)