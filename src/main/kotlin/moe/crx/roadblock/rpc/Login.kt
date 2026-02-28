package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.ConfigData
import moe.crx.roadblock.objects.social.PlatformCredentials
import moe.crx.roadblock.objects.PsnIssuerId
import moe.crx.roadblock.objects.miscellaneous.SystemNotificationType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class LoginRequest(
    var systemNotificationType: SystemNotificationType?,
    var platformCredential: PlatformCredentials?,
    @FromVersion("24.0.0")
    var platformUsername: String? = null,
    @FromVersion("24.0.0")
    var psnIssuerId: PsnIssuerId? = null,
) : RequestPacket()

@Serializable
data class LoginResponse(
    var data: ConfigData,
    var didMaintenanceFreeRefill: Boolean = false,
    var remindNewGarageLevel: Boolean = false,
    var isClientReloadNeeded: Boolean = false,
    var isVipPlayer: Boolean = false,
    @FromVersion("24.0.0")
    var isForcedUserName: Boolean = false,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleLogin(
    session: GameConnection,
    request: LoginRequest
) {
    TODO()
}