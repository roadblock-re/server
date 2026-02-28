package moe.crx.roadblock.objects.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.miscellaneous.DeviceInfo

@Serializable
data class UserAccountInfo(
    var credentials: List<String>,
    var lastLogin: String?,
    var alias: String?,
    var account: String,
    var installations: List<DeviceInfo>?,
    var isGhost: Boolean?,
)