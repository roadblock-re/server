package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.SocialConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ListGameFriendsRequest : RequestPacket()

@Serializable
data class ListGameFriendsResponse(
    var friendsList: List<SocialConnection> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleListGameFriends(
    session: GameConnection,
    request: ListGameFriendsRequest
) {
    session.sendResponse(ListGameFriendsResponse())
}