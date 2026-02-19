package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.multiplayer.GameServerConnectionInfo

@Serializable
data class LaunchGameCommandResponse(
    var action: String = "",
    var reason: String? = null,
    var error: String? = null,
    var code: String? = null,
    var success: Boolean = false,
    var controllerHost: String = "",
    var controllerTcpPort: UShort = 0u,
    var controllerHttpPort: UShort = 0u,
    var controllerHttpsPort: UShort = 0u,
    var roomId: String? = null,
    var gsConnectionInfo: GameServerConnectionInfo? = null,
)