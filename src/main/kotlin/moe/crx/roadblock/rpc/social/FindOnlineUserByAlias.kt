package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.OnlineUserData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class FindOnlineUserByAliasRequest(
    var alias: String,
) : RequestPacket()

@Serializable
data class FindOnlineUserByAliasResponse(
    var userData: OnlineUserData? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleFindOnlineUserByAlias(
    session: GameConnection,
    request: FindOnlineUserByAliasRequest
) {
    session.sendResponse(FindOnlineUserByAliasResponse())
}