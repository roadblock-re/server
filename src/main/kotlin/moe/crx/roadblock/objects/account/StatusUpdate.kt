package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
class StatusUpdateGroup // TODO

@Serializable
data class StatusUpdate(
    var statusUpdate: StatusUpdateGroup,
    var reactions: List<UInt>,
)