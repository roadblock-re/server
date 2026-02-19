package moe.crx.roadblock.objects.dailytasks

import kotlinx.serialization.Serializable

@Serializable
data class DailyTask(
    var isLocked: Boolean = true,
    var isClaimed: Boolean = false,
    var count: UInt = 0u,
    var isEnabled: Boolean = true,
)