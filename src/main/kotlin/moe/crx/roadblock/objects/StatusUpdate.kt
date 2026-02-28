package moe.crx.roadblock.objects

import kotlinx.serialization.Serializable
import moe.crx.roadblock.updates.StatusUpdateGroup

@Serializable
data class StatusUpdate(
    var statusUpdate: StatusUpdateGroup,
    var reactions: List<UInt>,
)