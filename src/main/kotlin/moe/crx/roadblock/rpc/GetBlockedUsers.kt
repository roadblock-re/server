package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.OnlineUserData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class GetBlockedUsersRequest : RequestPacket()

@Serializable
data class GetBlockedUsersResponse(
    var blockedUsers: List<OnlineUserData> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetBlockedUsers(
    session: GameConnection,
    request: GetBlockedUsersRequest
) {
    session.sendResponse(GetBlockedUsersResponse())
}