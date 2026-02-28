package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.social.OnlineUserData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GetOnlineUserInfoRequest(
    var credentials: Credentials,
) : RequestPacket()

@Serializable
data class GetOnlineUserInfoResponse(
    @UntilVersion("24.0.0") // TODO I'm not sure about this.
    var legacyUserData: OnlineUserData,
    @FromVersion("24.0.0")
    var userData: OnlineUserData? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetOnlineUserInfo(
    session: GameConnection,
    request: GetOnlineUserInfoRequest
) {
    TODO()
}